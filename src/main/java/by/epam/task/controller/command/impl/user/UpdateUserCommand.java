package by.epam.task.controller.command.impl.user;

import by.epam.task.controller.command.Command;
import by.epam.task.controller.command.ParameterName;
import by.epam.task.controller.command.Router;
import by.epam.task.controller.command.SessionAttribute;
import by.epam.task.exception.CommandException;
import by.epam.task.model.dao.ColumnName;
import by.epam.task.model.entity.User;
import by.epam.task.model.entity.UserRole;
import by.epam.task.model.service.impl.UserServiceImpl;
import com.google.protobuf.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

import static by.epam.task.controller.command.PageName.*;

public class UpdateUserCommand implements Command {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = null;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        if(user == null || user.getUserStatus().equals(UserRole.ADMIN))
        {
            return new Router(ERROR_404);
        }
        UserServiceImpl userService = new UserServiceImpl();
        Map<String, String> parameterUser = new HashMap<>();
        String field = request.getParameter(ParameterName.FIELD);
        switch (field) {
            case (ParameterName.EMAIL):
                parameterUser.put(ColumnName.EMAIL, request.getParameter(ParameterName.PARAMETER));
                try {
                    if (userService.updateEmail(parameterUser, user.getUserId())) {
                        user.setEmail(request.getParameter(ParameterName.PARAMETER));
                        logger.info("Successfully updated user email");
                    }
                    else {
                        logger.error("Incorrect data");
                    }
                    router = new Router(HOME);
                } catch (ServiceException e) {
                    logger.error("Error updated user email");
                    router = new Router(ERROR_500);
                }


                break;
            case (ParameterName.NAME):
                parameterUser.put(ColumnName.NAME, request.getParameter(ParameterName.PARAMETER));
                try {
                    if (userService.updateName(parameterUser, user.getUserId())) {
                    user.setName(request.getParameter(ParameterName.PARAMETER));
                    logger.info("Successfully updated user name");
                    }
                    else {
                        logger.error("Incorrect data");
                    }
                    router = new Router(HOME);
                } catch (ServiceException e) {
                    logger.error("Error updated user name");
                    router = new Router(ERROR_500);
                }
                break;
            case (ParameterName.SURNAME):
                parameterUser.put(ColumnName.SURNAME, request.getParameter(ParameterName.PARAMETER));
                try {
                    if (userService.updateSurname(parameterUser, user.getUserId())) {
                    user.setSurname(request.getParameter(ParameterName.PARAMETER));
                    logger.info("Successfully updated user surname");
                }
                    else {
                logger.error("Incorrect data");
                    }
                    router = new Router(HOME);
                } catch (ServiceException e) {
                    logger.error("Error updated user surname");
                    router = new Router(ERROR_500);
                }
                break;
            case (ParameterName.PHONE):
                parameterUser.put(ColumnName.PHONE, request.getParameter(ParameterName.PARAMETER));
                try {
                    if (userService.updatePhone(parameterUser, user.getUserId())) {
                    user.setPhone(request.getParameter(ParameterName.PARAMETER));
                    logger.info("Successfully updated user phone");
                    }
                    else {
                        logger.error("Incorrect data");
                    }
                    router = new Router(HOME);
                } catch (ServiceException e) {
                    logger.error("Error updated user phone");
                    router = new Router(ERROR_500);
                }
                break;
        }
        request.setAttribute(ParameterName.LOGIN, user.getLogin());
        request.setAttribute(ParameterName.EMAIL, user.getEmail());
        request.setAttribute(ParameterName.NAME, user.getName());
        request.setAttribute(ParameterName.SURNAME, user.getSurname());
        request.setAttribute(ParameterName.PHONE, user.getPhone());
        request.setAttribute(ParameterName.BALANCE, user.getBalance());
        session.setAttribute(SessionAttribute.SESSION_USER,user);

        return  router;
    }
}
