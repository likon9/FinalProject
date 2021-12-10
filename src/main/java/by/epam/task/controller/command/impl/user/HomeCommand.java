package by.epam.task.controller.command.impl.user;

import by.epam.task.controller.command.Command;
import by.epam.task.controller.command.ParameterName;
import by.epam.task.controller.command.Router;
import by.epam.task.controller.command.SessionAttribute;
import by.epam.task.exception.CommandException;
import by.epam.task.model.entity.User;
import by.epam.task.model.entity.UserRole;
import by.epam.task.model.entity.UserStatus;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.DecimalFormat;

import static by.epam.task.controller.command.PageName.ERROR_404;
import static by.epam.task.controller.command.PageName.HOME;

public class HomeCommand implements Command {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router;

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        if(user == null || user.getUserRole().equals(UserRole.ADMIN) || !user.getUserStatus().equals(UserStatus.ACTIVE)) { return new Router(ERROR_404); }
        request.setAttribute(ParameterName.LOGIN, user.getLogin());
        request.setAttribute(ParameterName.EMAIL, user.getEmail());
        request.setAttribute(ParameterName.NAME, user.getName());
        request.setAttribute(ParameterName.SURNAME, user.getSurname());
        request.setAttribute(ParameterName.PHONE, user.getPhone());
        request.setAttribute(ParameterName.BALANCE, user.getBalance());
        request.setAttribute(ParameterName.DISCOUNT, user.getDiscount());
        session.setAttribute(SessionAttribute.SESSION_USER,user);
        logger.info("Successfully navigated to the home page");
        router = new Router(HOME);
        return router;
    }
}
