package by.epam.task.command.impl;

import by.epam.task.command.Command;
import by.epam.task.exception.CommandException;
import by.epam.task.command.ParameterName;
import by.epam.task.command.Router;
import by.epam.task.model.service.impl.UserServiceImpl;
import by.epam.task.util.IdGenerate;
import com.google.protobuf.ServiceException;
import jakarta.servlet.http.HttpServletRequest;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import static by.epam.task.command.PageName.ERROR;
import static by.epam.task.command.PageName.REGISTRATION;
import static by.epam.task.model.dao.ColumnName.*;


public class RegistrationCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router;
        Map<String, String> newUser = new HashMap<>();
        newUser.put(USER_ID, String.valueOf(IdGenerate.generateId()));
        newUser.put(EMAIL, request.getParameter(ParameterName.EMAIL));
        newUser.put(LOGIN, request.getParameter(ParameterName.LOGIN));
        newUser.put(PASSWORD, request.getParameter(ParameterName.PASSWORD));
        newUser.put(NAME, request.getParameter(ParameterName.NAME));
        newUser.put(SURNAME, request.getParameter(ParameterName.SURNAME));
        newUser.put(PHONE, request.getParameter(ParameterName.PHONE));
        newUser.put(REGISTRATION_DATE, String.valueOf(Timestamp.from(Instant.now())));
        try{
            UserServiceImpl userService = new UserServiceImpl();
            userService.addUser(newUser);
            request.setAttribute(ParameterName.RES, "The account has been successfully created. Use your login and password to enter the system");
            router = new Router(REGISTRATION);
        }
        catch (ServiceException e) {
            router = new Router(ERROR);
        }
        return router;
    }
}

