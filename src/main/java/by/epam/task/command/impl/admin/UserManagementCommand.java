package by.epam.task.command.impl.admin;

import by.epam.task.command.Command;
import by.epam.task.command.ParameterName;
import by.epam.task.exception.CommandException;
import by.epam.task.command.Router;
import by.epam.task.command.SessionAttribute;
import by.epam.task.model.entity.User;
import by.epam.task.model.service.impl.UserServiceImpl;
import com.google.protobuf.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;

import static by.epam.task.command.PageName.ERROR;
import static by.epam.task.command.PageName.USER_LIST;

public class UserManagementCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        session.setAttribute(SessionAttribute.SESSION_USER,user);
        UserServiceImpl userService = new UserServiceImpl();
        List<User> userList = null;
        try {
            userList = userService.findAll();
            request.setAttribute(ParameterName.LIST, userList);
            router = new Router(USER_LIST);
        } catch (ServiceException e) {
            e.printStackTrace();
            router = new Router(ERROR);
        }
        return router;
    }
}

