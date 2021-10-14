package by.epam.task.controller.command.impl.admin;

import by.epam.task.controller.command.*;
import by.epam.task.exception.CommandException;
import by.epam.task.model.entity.User;
import by.epam.task.model.entity.UserRole;
import by.epam.task.model.entity.UserStatus;
import by.epam.task.model.service.impl.UserServiceImpl;
import com.google.protobuf.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static by.epam.task.controller.command.PageName.*;
import static by.epam.task.controller.command.ParameterName.*;

public class UserSelectCommand implements Command {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = null;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        if(user == null || user.getUserStatus().equals(UserRole.USER))
        {
            return new Router(ERROR_404);
        }
        session.setAttribute(SessionAttribute.SESSION_USER,user);
        UserServiceImpl userService = new UserServiceImpl();
        List<User> userList = null;
        switch (request.getParameter(ParameterName.SELECT)){
            case ALL_USERS:
                try {
                    userList = userService.findAll();
                    request.setAttribute(LIST, userList);
                    logger.info("Successfully in viewing all users");
                    router = new Router(USER_LIST);
                } catch (ServiceException e) {
                    logger.error("Error in viewing all users");
                    router = new Router(ERROR_500);
                }
                break;
            case ACTIVE_USERS:
                try {
                    userList = userService.findByStatus(String.valueOf(UserStatus.ACTIVE));
                    request.setAttribute(LIST, userList);
                    logger.info("Successfully in viewing active users");
                    router = new Router(USER_LIST);
                } catch (ServiceException e) {
                    logger.info("Error in viewing active users");
                    router = new Router(ERROR_500);
                }
                break;
            case BLOCKED_USERS:
                try {
                    userList = userService.findByStatus(String.valueOf(UserStatus.BLOCKED));
                    request.setAttribute(LIST, userList);
                    logger.info("Successfully in viewing block users");
                    router = new Router(USER_LIST);
                } catch (ServiceException e) {
                    logger.error("Error in viewing block users");
                    router = new Router(ERROR_500);
                }
                break;
            case DELETED_USERS:
                try {
                    userList = userService.findByStatus(String.valueOf(UserStatus.DELETED));
                    request.setAttribute(LIST, userList);
                    logger.info("Successfully in viewing deleted users");
                    router = new Router(USER_LIST);
                } catch (ServiceException e) {
                    logger.error("Error in viewing deleted users");
                    router = new Router(ERROR_500);
                }
                break;
        }
        return router;
    }
}