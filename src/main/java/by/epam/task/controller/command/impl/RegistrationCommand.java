package by.epam.task.controller.command.impl;

import by.epam.task.controller.command.*;
import by.epam.task.exception.CommandException;
import by.epam.task.model.service.impl.UserServiceImpl;
import by.epam.task.exception.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import static by.epam.task.controller.command.PageName.REGISTRATION;
import static by.epam.task.model.dao.ColumnName.*;
import static by.epam.task.model.dao.ColumnName.LOGIN;


public class RegistrationCommand implements Command {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router;
        String phone = request.getParameter(ParameterName.SELECT) +request.getParameter(ParameterName.PHONE);
        Map<String, String> newUser = new HashMap<>();
        newUser.put(EMAIL, request.getParameter(ParameterName.EMAIL));
        newUser.put(LOGIN, request.getParameter(ParameterName.LOGIN));
        newUser.put(PASSWORD, request.getParameter(ParameterName.PASSWORD));
        newUser.put(NAME, request.getParameter(ParameterName.NAME));
        newUser.put(SURNAME, request.getParameter(ParameterName.SURNAME));
        newUser.put(PHONE, phone);
        newUser.put(REGISTRATION_DATE, String.valueOf(Timestamp.from(Instant.now())));
        UserServiceImpl userService = new UserServiceImpl();

        try {
            if(userService.addUser(newUser)){
                request.setAttribute(ParameterName.RES, true);
                logger.info("The account has been successfully created.");
                router = new Router(PageName.LOGIN);
            }else {
                request.setAttribute(ParameterName.RES, true);
                logger.error("Incorrect data.");
                router = new Router(REGISTRATION);
            }
        } catch (ServiceException e) {
            request.setAttribute(ParameterName.FAIL, true);
            logger.error("Error registration user.", e);
            router = new Router(REGISTRATION);
        }
        return router;
    }
}

