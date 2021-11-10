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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.epam.task.controller.command.PageName.*;
import static by.epam.task.model.dao.ColumnName.USER_STATUS;

public class BlockUserCommand implements Command {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        if(user == null || user.getUserRole().equals(UserRole.USER)) { return new Router(ERROR_404); }
        session.setAttribute(SessionAttribute.SESSION_USER, user);
        UserServiceImpl userService = new UserServiceImpl();
        Map<String, String> updateUser = new HashMap<>();
        Long userId = Long.valueOf(request.getParameter(ParameterName.USER_ID));
        updateUser.put(USER_STATUS, "2");
            try {
                if(userService.updateStatus(updateUser, userId)){
                    request.setAttribute(ParameterName.RES_BLOCK_USER, true);
                    logger.info("Successfully block user");
                } else{
                    logger.error("Error block user");
                }
                List<User> userList = null;
                userList = userService.findAll();
                request.setAttribute(ParameterName.LIST, userList);
                router = new Router(USER_LIST);
            } catch (ServiceException e) {
                logger.error("Error block user" + e);
                router = new Router(ERROR_500);
            }
            return router;
        }
    }

