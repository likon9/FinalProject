package by.epam.finalTask.command.impl;

import by.epam.finalTask.command.Command;
import by.epam.finalTask.command.CommandException;
import by.epam.finalTask.command.ParameterName;
import by.epam.finalTask.model.service.impl.UserServiceImpl;
import by.epam.finalTask.util.IdGenerate;
import com.google.protobuf.ServiceException;
import jakarta.servlet.http.HttpServletRequest;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import static by.epam.finalTask.command.PageName.ERROR;
import static by.epam.finalTask.command.PageName.REGISTRATION;
import static by.epam.finalTask.model.dao.ColumnName.*;


public class RegistrationCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page;

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
            request.setAttribute("res", "The account has been successfully created. Use your login and password to enter the system");
            page = REGISTRATION.getPath();
        }
        catch (NumberFormatException e){
            page = ERROR.getPath();
        } catch (ServiceException e) {
            page = ERROR.getPath();
            e.printStackTrace();
        }

        return page;
    }
}

