package by.epam.task.controller.command.impl.admin.userManagement;

import by.epam.task.controller.command.Command;
import by.epam.task.controller.command.ParameterName;
import by.epam.task.controller.command.Router;
import by.epam.task.controller.command.SessionAttribute;
import by.epam.task.exception.CommandException;
import by.epam.task.model.entity.User;
import by.epam.task.model.service.impl.UserServiceImpl;
import com.google.protobuf.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;

import static by.epam.task.controller.command.PageName.ERROR_500;
import static by.epam.task.controller.command.PageName.USER_LIST;

public class SelectByUserEmailCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
            Router router;
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
            session.setAttribute(SessionAttribute.SESSION_USER, user);
            UserServiceImpl userService = new UserServiceImpl();
            List<User> userList = null;
            try {
                userList = userService.findByEmail(request.getParameter(ParameterName.EMAIL));
                request.setAttribute(ParameterName.LIST, userList);
                router = new Router(USER_LIST);
            } catch (ServiceException e) {
                e.printStackTrace();
                router = new Router(ERROR_500);
            }
            return router;
        }
}
