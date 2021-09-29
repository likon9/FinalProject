package by.epam.finalTask.command.impl;

import by.epam.finalTask.command.Command;

import by.epam.finalTask.command.ParameterName;
import by.epam.finalTask.command.Router;
import by.epam.finalTask.command.SessionAttribute;
import by.epam.finalTask.model.entity.User;
import by.epam.finalTask.model.service.impl.UserServiceImpl;
import by.epam.finalTask.util.CodeGenerate;
import by.epam.finalTask.util.MailSender;
import com.google.protobuf.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.lang.reflect.Parameter;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import static by.epam.finalTask.command.PageName.*;
import static by.epam.finalTask.command.PageName.CODE;
import static by.epam.finalTask.command.PageName.LOGIN;
import static by.epam.finalTask.command.ParameterName.*;
import static by.epam.finalTask.model.entity.UserRole.ADMIN;
import static by.epam.finalTask.model.entity.UserStatus.*;

public class LoginCommand implements Command {

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = null;
        String login = request.getParameter(ParameterName.LOGIN);
        String password = request.getParameter(ParameterName.PASSWORD);
        HttpSession session = request.getSession();
        UserServiceImpl userService = new UserServiceImpl();
        try {
           if(userService.findUser(login, password))

           {
               Optional<User> user = userService.findByLogin(login);
               User sessionUser = user.get();
               if(String.valueOf(sessionUser.getUserRole()).equals(String.valueOf(ADMIN)))
               {
                   router = new Router(HOME_ADMIN.getPath());
               }
               else if (String.valueOf(sessionUser.getUserStatus()).equals(String.valueOf(ACTIVE)))
               {
                   String email = sessionUser.getEmail();
                   CodeGenerate gen = new CodeGenerate(ThreadLocalRandom.current());
                   String code = gen.nextString();
                   MailSender.sendMail(email,code);
                   session.setAttribute(SessionAttribute.SESSION_CODE, code);
                   router = new Router(CODE.getPath());
               }
               else if(String.valueOf(sessionUser.getUserStatus()).equals(String.valueOf(BLOCKED)))
               {
                   request.setAttribute("fail", "Failed to sign in. Your account has been blocked.");
                   router = new Router(LOGIN.getPath());
               }
               else if(String.valueOf(sessionUser.getUserStatus()).equals(String.valueOf(DELETED)))
               {
                   request.setAttribute("fail", "Failed to sign in. Your account has been deleted.");
                   router = new Router(LOGIN.getPath());
               }
               session.setAttribute(SessionAttribute.SESSION_USER, sessionUser);
           }
           else {
               request.setAttribute("fail", "Failed to sign in. <br> Please make sure that you've entered your login and password correctly.");
               router = new Router(LOGIN.getPath());
           }

        } catch (ServiceException e) {
            router = new Router(ERROR.getPath());
            e.printStackTrace();
        }
        return router;

    }
}
