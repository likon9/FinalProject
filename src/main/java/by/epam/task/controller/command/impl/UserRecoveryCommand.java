package by.epam.task.controller.command.impl;

import by.epam.task.controller.command.*;
import by.epam.task.exception.CommandException;
import by.epam.task.model.entity.User;
import by.epam.task.model.service.impl.UserServiceImpl;
import com.google.protobuf.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

import static by.epam.task.model.dao.ColumnName.USER_STATUS;

public class UserRecoveryCommand implements Command {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = null;
        UserServiceImpl userService =new UserServiceImpl();
        User user = null;
        try {
            user = userService.findByLogin(request.getParameter(ParameterName.LOGIN)).get();
            logger.info("Use found.");
            Map<String, String> updateUser = new HashMap<>();
            updateUser.put(USER_STATUS, "1");
            try {
                userService.updateStatus(updateUser, user.getUserId());
                request.setAttribute(ParameterName.RES, user.getLogin() + " was restored");
                logger.info("The user was restored successfully.");
                router = new Router(PageName.LOGIN);
            } catch (ServiceException e) {
                logger.error("The user was restored error.");
                router = new Router(PageName.ERROR_404);
            }
        } catch (ServiceException e) {
            logger.error("User is not found.");
            router = new Router(PageName.ERROR_404);
        }

        return router;
    }
}
