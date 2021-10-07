package by.epam.finalTask.command.impl.user;

import by.epam.finalTask.command.*;
import by.epam.finalTask.model.entity.User;
import by.epam.finalTask.model.service.impl.UserServiceImpl;
import com.google.protobuf.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.epam.finalTask.model.dao.ColumnName.USER_ID;
import static by.epam.finalTask.model.dao.ColumnName.USER_STATUS;

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
        } catch (ServiceException serviceException) {
            serviceException.printStackTrace();
        }
        request.setAttribute("fail","user:  " + user.getLogin() + " has been deleted");

            router = new Router(PageName.LOGIN.getPath());

        session.setAttribute(SessionAttribute.SESSION_USER,null);
        return  router;
    }
}
