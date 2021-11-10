package by.epam.task.controller.command.impl.admin.userManagement;

import by.epam.task.controller.command.*;
import by.epam.task.exception.CommandException;
import by.epam.task.model.entity.User;
import by.epam.task.model.entity.UserRole;
import by.epam.task.model.service.impl.UserServiceImpl;
import by.epam.task.exception.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static by.epam.task.controller.command.PageName.*;

public class SelectByUserPhoneCommand implements Command {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        if(user == null || user.getUserRole().equals(UserRole.USER)) { return new Router(ERROR_404); }
        session.setAttribute(SessionAttribute.SESSION_USER, user);
        UserServiceImpl userService = new UserServiceImpl();
        List<User> userList = null;
        try {
            userList = userService.findByPhone(Integer.parseInt(request.getParameter(ParameterName.PHONE)));
            request.setAttribute(ParameterName.LIST, userList);
            logger.info("Successfully select user by phone");
            router = new Router(USER_LIST);
        } catch (ServiceException e) {
            logger.error("Error select user by surname" + e);
            router = new Router(ERROR_500);
        }
        return router;
    }
}