package by.epam.finalTask.command.impl.admin;

import by.epam.finalTask.command.*;
import by.epam.finalTask.model.entity.User;
import by.epam.finalTask.model.entity.UserStatus;
import by.epam.finalTask.model.service.impl.UserServiceImpl;
import com.google.protobuf.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;

import static by.epam.finalTask.command.PageName.USER_LIST;
import static by.epam.finalTask.command.ParameterName.*;

public class UserSelectCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = null;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        session.setAttribute(SessionAttribute.SESSION_USER,user);
        UserServiceImpl userService = new UserServiceImpl();
        List<User> userList = null;

        if(request.getParameter(ParameterName.SELECT).equals(ALL_USERS))
        {
            try {
                userList = userService.findAll();
            } catch (ServiceException e) {
                e.printStackTrace();
            }
            request.setAttribute("list", userList);
            router = new Router(USER_LIST.getPath());
        }
        else if(request.getParameter(ParameterName.SELECT).equals(ACTIVE_USERS))
        {
            try {
                userList = userService.findByStatus(String.valueOf(UserStatus.ACTIVE));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
            request.setAttribute("list", userList);
            router = new Router(USER_LIST.getPath());
        }
        else if(request.getParameter(ParameterName.SELECT).equals(BLOCKED_USERS))
        {
            try {
                userList = userService.findByStatus(String.valueOf(UserStatus.BLOCKED));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
            request.setAttribute("list", userList);
            router = new Router(USER_LIST.getPath());
        }
        else if(request.getParameter(ParameterName.SELECT).equals(DELETED_USERS))
        {
            try {
                userList = userService.findByStatus(String.valueOf(UserStatus.DELETED));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
            request.setAttribute("list", userList);
            router = new Router(USER_LIST.getPath());
        }
        return router;
    }
}