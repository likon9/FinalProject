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
import by.epam.task.exception.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import static by.epam.task.controller.command.PageName.*;

public class TopUpBalanceCommand implements Command {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        if(user == null || user.getUserStatus().equals(UserRole.ADMIN)) { return new Router(ERROR_404); }
        session.setAttribute(SessionAttribute.SESSION_USER,user);
        Double newBalance = Double.parseDouble(String.valueOf(user.getBalance())) + Double.valueOf(request.getParameter(ParameterName.BALANCE));
        UserServiceImpl userService = new UserServiceImpl();
        Map<String, String> parameters = new HashMap<>();
        parameters.put(ColumnName.BALANCE, String.valueOf(newBalance));
        newBalance = Math.round(newBalance * 100.0) / 100.0;
        try {
            userService.updateBalance(parameters,user.getUserId());
            user.setBalance(BigDecimal.valueOf(newBalance));
            request.setAttribute(ParameterName.LOGIN, user.getLogin());
            request.setAttribute(ParameterName.EMAIL, user.getEmail());
            request.setAttribute(ParameterName.NAME, user.getName());
            request.setAttribute(ParameterName.SURNAME, user.getSurname());
            request.setAttribute(ParameterName.PHONE, user.getPhone());
            request.setAttribute(ParameterName.BALANCE, user.getBalance());
            request.setAttribute(ParameterName.RES_TOP_UP_BALANCE, true);
            logger.info("Successful replenishment of the balance.");
            router = new Router(HOME);
        } catch (ServiceException e) {
            logger.error("Error replenishment of the balance." + e);
            router = new Router(ERROR_500);
        }

        return router;
    }
}
