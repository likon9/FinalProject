package by.epam.task.command.impl.admin;

import by.epam.task.command.*;
import by.epam.task.exception.CommandException;
import by.epam.task.model.entity.User;
import by.epam.task.model.entity.UserStatus;
import by.epam.task.model.service.impl.UserServiceImpl;
import com.google.protobuf.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;

import static by.epam.task.command.PageName.*;
import static by.epam.task.command.ParameterName.*;

public class UserSelectCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = null;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        session.setAttribute(SessionAttribute.SESSION_USER,user);
        UserServiceImpl userService = new UserServiceImpl();
        List<User> userList = null;
        switch (request.getParameter(ParameterName.SELECT)){
            case ALL_USERS:
                try {
                    userList = userService.findAll();
                    request.setAttribute(LIST, userList);
                    router = new Router(USER_LIST);
                } catch (ServiceException e) {
                    e.printStackTrace();
                    router = new Router(ERROR);
                }
                break;
            case ACTIVE_USERS:
                try {
                    userList = userService.findByStatus(String.valueOf(UserStatus.ACTIVE));
                    request.setAttribute(LIST, userList);
                    router = new Router(USER_LIST);
                } catch (ServiceException e) {
                    e.printStackTrace();
                    router = new Router(ERROR);
                }
                break;
            case BLOCKED_USERS:
                try {
                    userList = userService.findByStatus(String.valueOf(UserStatus.BLOCKED));
                    request.setAttribute(LIST, userList);
                    router = new Router(USER_LIST);
                } catch (ServiceException e) {
                    e.printStackTrace();
                    router = new Router(ERROR);
                }
                break;
            case DELETED_USERS:
                try {
                    userList = userService.findByStatus(String.valueOf(UserStatus.DELETED));
                    request.setAttribute(LIST, userList);
                    router = new Router(USER_LIST);
                } catch (ServiceException e) {
                    e.printStackTrace();
                    router = new Router(ERROR);
                }
                break;
        }
        return router;
    }
}