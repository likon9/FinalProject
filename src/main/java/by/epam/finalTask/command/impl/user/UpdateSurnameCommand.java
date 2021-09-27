package by.epam.finalTask.command.impl.user;

import by.epam.finalTask.command.Command;
import by.epam.finalTask.command.CommandException;
import by.epam.finalTask.command.ParameterName;
import by.epam.finalTask.command.SessionAttribute;
import by.epam.finalTask.model.dao.ColumnName;
import by.epam.finalTask.model.entity.User;
import by.epam.finalTask.model.service.impl.UserServiceImpl;
import com.google.protobuf.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

import static by.epam.finalTask.command.PageName.SETTING_USER;

public class UpdateSurnameCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {

        String page = null;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        UserServiceImpl userService = new UserServiceImpl();
        Map<String, String> parameterUser = new HashMap<>();
        parameterUser.put(ColumnName.SURNAME, request.getParameter(ParameterName.SURNAME));
        try {
            userService.updateSurname(parameterUser,user.getUserId());
            user.setSurname(request.getParameter(ParameterName.SURNAME));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        request.setAttribute(ParameterName.EMAIL, user.getEmail());
        request.setAttribute(ParameterName.NAME, user.getName());
        request.setAttribute(ParameterName.SURNAME, user.getSurname());
        request.setAttribute(ParameterName.PHONE, user.getPhone());
        session.setAttribute(SessionAttribute.SESSION_USER,user);
        page = SETTING_USER.getPath();

        return page;

    }
}
