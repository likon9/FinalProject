package by.epam.finalTask.command.impl.user;

import by.epam.finalTask.command.*;
import by.epam.finalTask.model.dao.ColumnName;
import by.epam.finalTask.model.entity.User;
import by.epam.finalTask.model.service.impl.UserServiceImpl;
import com.google.protobuf.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

import static by.epam.finalTask.command.PageName.*;

public class UpdateUserCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = null;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        UserServiceImpl userService = new UserServiceImpl();
        Map<String, String> parameterUser = new HashMap<>();
        String field = request.getParameter(ParameterName.FIELD);
        System.out.println(field);
        switch (field){
            case (ParameterName.EMAIL):

                parameterUser.put(ColumnName.EMAIL, request.getParameter(ParameterName.PARAMETER));
                try {
                    userService.updateEmail(parameterUser,user.getUserId());
                } catch (ServiceException e) {
                    e.printStackTrace();
                }
                user.setEmail(request.getParameter(ParameterName.PARAMETER));
                break;
            case (ParameterName.NAME):

                parameterUser.put(ColumnName.NAME, request.getParameter(ParameterName.PARAMETER));
                try {
                    userService.updateName(parameterUser,user.getUserId());
                } catch (ServiceException e) {
                    e.printStackTrace();
                }
                user.setName(request.getParameter(ParameterName.PARAMETER));

                break;
            case (ParameterName.SURNAME):

                parameterUser.put(ColumnName.SURNAME, request.getParameter(ParameterName.PARAMETER));
                try {
                    userService.updateSurname(parameterUser,user.getUserId());
                } catch (ServiceException e) {
                    e.printStackTrace();
                }
                user.setSurname(request.getParameter(ParameterName.PARAMETER));

                break;
            case (ParameterName.PHONE):

                parameterUser.put(ColumnName.PHONE, request.getParameter(ParameterName.PARAMETER));
                try {
                    userService.updatePhone(parameterUser,user.getUserId());
                } catch (ServiceException e) {
                    e.printStackTrace();
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
        router = new Router(HOME.getPath());

        return  router;
    }
}
