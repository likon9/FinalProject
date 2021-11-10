package by.epam.task.controller.command.impl.user;

import by.epam.task.controller.command.*;
import by.epam.task.exception.CommandException;
import by.epam.task.model.entity.User;
import by.epam.task.model.entity.UserRole;
import by.epam.task.model.entity.UserStatus;
import by.epam.task.model.service.impl.UserServiceImpl;
import by.epam.task.exception.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

import static by.epam.task.controller.command.PageName.ERROR_404;
import static by.epam.task.model.dao.ColumnName.USER_STATUS;

public class DeleteUserCommand implements Command {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        if(user == null || user.getUserRole().equals(UserRole.ADMIN) || !user.getUserStatus().equals(UserStatus.ACTIVE)) { return new Router(ERROR_404); }
        UserServiceImpl userService = new UserServiceImpl();
        Map<String, String> updateUser = new HashMap<>();
        updateUser.put(USER_STATUS, "3");
        try {
            userService.updateStatus(updateUser, user.getUserId());
            request.setAttribute(ParameterName.RES_USER_DELETE,true);
            session.setAttribute(SessionAttribute.SESSION_USER,null);
            logger.info("The user was successfully deleted.");
            router = new Router(PageName.LOGIN);
        } catch (ServiceException e) {
            logger.error("The user wasn't successfully deleted." + e);
            router = new Router(PageName.ERROR_500);
        }
        return router;
    }
}
