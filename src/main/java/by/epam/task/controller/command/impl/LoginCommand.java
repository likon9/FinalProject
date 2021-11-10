package by.epam.task.controller.command.impl;

import by.epam.task.controller.command.*;

import by.epam.task.model.entity.User;
import by.epam.task.model.service.impl.UserServiceImpl;
import by.epam.task.util.CodeGenerator;
import by.epam.task.util.MailSender;
import by.epam.task.exception.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import static by.epam.task.controller.command.PageName.*;
import static by.epam.task.controller.command.PageName.CODE;
import static by.epam.task.controller.command.PageName.LOGIN;
import static by.epam.task.model.entity.UserRole.ADMIN;
import static by.epam.task.model.entity.UserStatus.*;

public class LoginCommand implements Command {

    private static final Logger logger = LogManager.getLogger();
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
                   logger.info("Successful admin authorization..");
                   router = new Router(HOME_ADMIN);
               } else if (String.valueOf(sessionUser.getUserStatus()).equals(String.valueOf(ACTIVE))) {
                   String email = sessionUser.getEmail();
                   CodeGenerator gen = new CodeGenerator(ThreadLocalRandom.current());
                   String code = gen.nextString();
                   MailSender.sendMail(email,code);
                   session.setAttribute(SessionAttribute.SESSION_CODE, code);
                   logger.info("Successful user authorization..");
                   router = new Router(CODE);
               } else if(String.valueOf(sessionUser.getUserStatus()).equals(String.valueOf(BLOCKED))) {
                   request.setAttribute(ParameterName.RES_USER_BLOCK, true);
                   logger.info("This user is blocked.");
                   router = new Router(LOGIN);
               } else if(String.valueOf(sessionUser.getUserStatus()).equals(String.valueOf(DELETED))) {
                   request.setAttribute(ParameterName.LOGIN, sessionUser.getLogin());
                   logger.info("This user is deleted.");
                   router = new Router(USER_RECOVERY);
               }
               session.setAttribute(SessionAttribute.SESSION_USER, sessionUser);
           } else {
               logger.error("User with this login and password was not found.");
               request.setAttribute(ParameterName.RES_USER_NOT_FOUND, true);
               router = new Router(LOGIN);
           }
        } catch (ServiceException e) {
            logger.error("Error during login user: ", e);
            router = new Router(ERROR_500);
        }
        return router;
    }
}
