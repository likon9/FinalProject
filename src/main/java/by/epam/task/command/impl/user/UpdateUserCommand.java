package by.epam.task.command.impl.user;

import by.epam.task.command.*;
import by.epam.task.exception.CommandException;
import by.epam.task.model.dao.ColumnName;
import by.epam.task.model.entity.User;
import by.epam.task.model.service.impl.UserServiceImpl;
import com.google.protobuf.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

import static by.epam.task.command.PageName.*;

public class UpdateUserCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = null;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        UserServiceImpl userService = new UserServiceImpl();
        Map<String, String> parameterUser = new HashMap<>();
        String field = request.getParameter(ParameterName.FIELD);
        switch (field){
            case (ParameterName.EMAIL):
                parameterUser.put(ColumnName.EMAIL, request.getParameter(ParameterName.PARAMETER));
                try {
                    userService.updateEmail(parameterUser,user.getUserId());
                } catch (ServiceException e) {
                }
                user.setEmail(request.getParameter(ParameterName.PARAMETER));
                break;
            case (ParameterName.NAME):
                parameterUser.put(ColumnName.NAME, request.getParameter(ParameterName.PARAMETER));
                try {
                    userService.updateName(parameterUser,user.getUserId());
                } catch (ServiceException e) {
                }
                user.setName(request.getParameter(ParameterName.PARAMETER));
                break;
            case (ParameterName.SURNAME):
                parameterUser.put(ColumnName.SURNAME, request.getParameter(ParameterName.PARAMETER));
                try {
                    userService.updateSurname(parameterUser,user.getUserId());
                } catch (ServiceException e) {
                }
                user.setSurname(request.getParameter(ParameterName.PARAMETER));
                break;
            case (ParameterName.PHONE):
                parameterUser.put(ColumnName.PHONE, request.getParameter(ParameterName.PARAMETER));
                try {
                    userService.updatePhone(parameterUser,user.getUserId());
                } catch (ServiceException e) {
                }
                user.setPhone(Integer.parseInt(request.getParameter(ParameterName.PARAMETER)));
                break;
        }
        request.setAttribute(ParameterName.LOGIN, user.getLogin());
        request.setAttribute(ParameterName.EMAIL, user.getEmail());
        request.setAttribute(ParameterName.NAME, user.getName());
        request.setAttribute(ParameterName.SURNAME, user.getSurname());
        request.setAttribute(ParameterName.PHONE, user.getPhone());
        session.setAttribute(SessionAttribute.SESSION_USER,user);
        router = new Router(HOME);

        return  router;
    }
}
