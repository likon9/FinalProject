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

import java.util.HashMap;
import java.util.Map;

import static by.epam.task.controller.command.PageName.*;

public class NullificationContractCommand implements Command {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = null;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        if(user == null || user.getUserRole().equals(UserRole.ADMIN) || !user.getUserStatus().equals(UserStatus.ACTIVE)) { return new Router(ERROR_404); }
        session.setAttribute(SessionAttribute.SESSION_USER,user);
        Map<String, String> parameters = new HashMap<>();
        parameters.put(ColumnName.CONTRACT_STATUS, String.valueOf(2));
        ContractServiceImpl contractService = new ContractServiceImpl();
        try {
            contractService.updateStatusContract(parameters, Long.valueOf(request.getParameter(ParameterName.CONTRACT_ID)));
            request.setAttribute(ParameterName.LOGIN, user.getLogin());
            request.setAttribute(ParameterName.EMAIL, user.getEmail());
            request.setAttribute(ParameterName.NAME, user.getName());
            request.setAttribute(ParameterName.SURNAME, user.getSurname());
            request.setAttribute(ParameterName.PHONE, user.getPhone());
            request.setAttribute(ParameterName.BALANCE, user.getBalance());
            request.setAttribute(ParameterName.DISCOUNT, user.getDiscount());
            request.setAttribute(ParameterName.RES_DISCONNECT_TARIFF, true);
            session.setAttribute(SessionAttribute.SESSION_USER,user);
            logger.info("Contract disconnected successfully");
            router = new Router(HOME);
        } catch (ServiceException e) {
            logger.error("Contract disconnected error" + e);
            router = new Router(ERROR_500);
        }

        return router;
    }
}
