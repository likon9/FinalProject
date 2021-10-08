package by.epam.task.command.impl;

import by.epam.task.command.Command;

import by.epam.task.command.ParameterName;
import by.epam.task.command.Router;
import by.epam.task.command.SessionAttribute;
import by.epam.task.model.entity.User;
import by.epam.task.model.service.impl.UserServiceImpl;
import by.epam.task.util.CodeGenerator;
import by.epam.task.util.MailSender;
import com.google.protobuf.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import static by.epam.task.command.PageName.*;
import static by.epam.task.command.PageName.CODE;
import static by.epam.task.command.PageName.LOGIN;
import static by.epam.task.model.entity.UserRole.ADMIN;
import static by.epam.task.model.entity.UserStatus.*;

public class LoginCommand implements Command {

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = null;
        String login = request.getParameter(ParameterName.LOGIN);
        String password = request.getParameter(ParameterName.PASSWORD);
        HttpSession session = request.getSession();
        UserServiceImpl userService = new UserServiceImpl();
        try {
           if(userService.findUser(login, password)) {
               Optional<User> user = userService.findByLogin(login);
               User sessionUser = user.get();
               if(String.valueOf(sessionUser.getUserRole()).equals(String.valueOf(ADMIN))) {
                   router = new Router(HOME_ADMIN);
               }
               else if (String.valueOf(sessionUser.getUserStatus()).equals(String.valueOf(ACTIVE))) {
                   String email = sessionUser.getEmail();
                   CodeGenerator gen = new CodeGenerator(ThreadLocalRandom.current());
                   String code = gen.nextString();
                   MailSender.sendMail(email,code);
                   session.setAttribute(SessionAttribute.SESSION_CODE, code);
                   router = new Router(CODE);
               }
               else if(String.valueOf(sessionUser.getUserStatus()).equals(String.valueOf(BLOCKED))) {
                   request.setAttribute(ParameterName.FAIL, "Failed to sign in. Your account has been blocked.");
                   router = new Router(LOGIN);
               }
               else if(String.valueOf(sessionUser.getUserStatus()).equals(String.valueOf(DELETED))) {
                   request.setAttribute(ParameterName.FAIL, "Failed to sign in. Your account has been deleted.");
                   router = new Router(LOGIN);
               }
               session.setAttribute(SessionAttribute.SESSION_USER, sessionUser);
           }
           else {
               request.setAttribute(ParameterName.FAIL, "Failed to sign in. <br> Please make sure that you've entered your login and password correctly.");
               router = new Router(LOGIN);
           }
        } catch (ServiceException e) {
            router = new Router(ERROR);
        }
        return router;
    }
}
