package by.epam.task.command.impl.user;

import by.epam.task.command.*;
import by.epam.task.exception.CommandException;
import by.epam.task.model.entity.User;
import by.epam.task.model.service.impl.UserServiceImpl;
import com.google.protobuf.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

import static by.epam.task.model.dao.ColumnName.USER_STATUS;

public class DeleteUserCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        UserServiceImpl userService = new UserServiceImpl();
        Map<String, String> updateUser = new HashMap<>();
        updateUser.put(USER_STATUS, "3");
        try {
            userService.updateStatus(updateUser, user.getUserId());
        } catch (ServiceException e) {
        }
        request.setAttribute(ParameterName.FAIL,"user:  " + user.getLogin() + " has been deleted");
        router = new Router(PageName.LOGIN);
        session.setAttribute(SessionAttribute.SESSION_USER,null);
        return  router;
    }
}
