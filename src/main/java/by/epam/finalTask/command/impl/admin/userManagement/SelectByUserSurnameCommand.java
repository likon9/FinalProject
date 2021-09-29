package by.epam.finalTask.command.impl.admin.userManagement;

import by.epam.finalTask.command.Command;
import by.epam.finalTask.command.CommandException;
import by.epam.finalTask.command.Router;
import by.epam.finalTask.command.SessionAttribute;
import by.epam.finalTask.model.entity.User;
import by.epam.finalTask.model.service.impl.UserServiceImpl;
import com.google.protobuf.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;

import static by.epam.finalTask.command.PageName.ERROR;
import static by.epam.finalTask.command.PageName.USER_LIST;

public class SelectByUserSurnameCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        session.setAttribute(SessionAttribute.SESSION_USER, user);
        String surname = request.getParameter("surname");
        UserServiceImpl userService = new UserServiceImpl();
        List<User> userList = null;
        try {
            userList = userService.findBySurname(surname);
            request.setAttribute("list", userList);
            router = new Router(USER_LIST.getPath());
        } catch (ServiceException e) {
            e.printStackTrace();
            router = new Router(ERROR.getPath());
        }
        return router;
    }
}
