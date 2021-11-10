package by.epam.task.controller.command.impl.user;

import by.epam.task.controller.command.*;
import by.epam.task.exception.CommandException;
import by.epam.task.exception.ServiceException;
import by.epam.task.model.dao.ColumnName;
import by.epam.task.model.entity.User;
import by.epam.task.model.entity.UserRole;
import by.epam.task.model.entity.UserStatus;
import by.epam.task.model.service.impl.ContractServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import static by.epam.task.controller.command.PageName.*;

public class ConnectTariffCommand implements Command {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        if(user == null || user.getUserRole().equals(UserRole.ADMIN) || !user.getUserStatus().equals(UserStatus.ACTIVE)) { return new Router(ERROR_404); }
        session.setAttribute(SessionAttribute.SESSION_USER,user);
        ContractServiceImpl contractService = new ContractServiceImpl();
        Map<String, String> parameters = new HashMap<>();
        parameters.put(ColumnName.CONNECTION_DATE, String.valueOf(Timestamp.from(Instant.now())));
        parameters.put(ColumnName.CONTRACT_USER_ID, String.valueOf(user.getUserId()));
        parameters.put(ColumnName.CONTRACT_TARIFF_PLAN_ID, (request.getParameter(ParameterName.TARIFF_PLAN_ID)));
        try {
            contractService.addContract(parameters);
            request.setAttribute(ParameterName.LOGIN, user.getLogin());
            request.setAttribute(ParameterName.EMAIL, user.getEmail());
            request.setAttribute(ParameterName.NAME, user.getName());
            request.setAttribute(ParameterName.SURNAME, user.getSurname());
            request.setAttribute(ParameterName.PHONE, user.getPhone());
            request.setAttribute(ParameterName.BALANCE, user.getBalance());
            request.setAttribute(ParameterName.DISCOUNT, user.getDiscount());
            session.setAttribute(SessionAttribute.SESSION_USER,user);
            request.setAttribute(ParameterName.RES_CONNECT_TARIFF, true);
            logger.info("The contract was successfully connected.");
            router = new Router(HOME);
        } catch (ServiceException e) {
            logger.error("The contract wasn't successfully connected." + e);
            router = new Router(ERROR_500);
        }
        return router;
    }
}
