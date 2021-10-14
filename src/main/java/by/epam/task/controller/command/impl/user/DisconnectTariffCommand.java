package by.epam.task.controller.command.impl.user;

import by.epam.task.controller.command.Command;
import by.epam.task.controller.command.ParameterName;
import by.epam.task.controller.command.Router;
import by.epam.task.controller.command.SessionAttribute;
import by.epam.task.exception.CommandException;
import by.epam.task.exception.ServiceException;
import by.epam.task.model.entity.Contract;
import by.epam.task.model.entity.User;
import by.epam.task.model.entity.UserRole;
import by.epam.task.model.service.impl.ContractServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.epam.task.controller.command.PageName.DISCONNECT_TARIFF;
import static by.epam.task.controller.command.PageName.ERROR_404;

public class DisconnectTariffCommand implements Command {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        if(user == null || user.getUserStatus().equals(UserRole.ADMIN))
        {
            return new Router(ERROR_404);
        }
        session.setAttribute(SessionAttribute.SESSION_USER,user);
        ContractServiceImpl contractService = new ContractServiceImpl();
        Contract contract = null;
        try {
            contract = contractService.findByContractId(Long.parseLong(request.getParameter(ParameterName.CONTRACT_ID))).get();
            request.setAttribute(ParameterName.CONTRACT_ID, contract.getContractId());
            request.setAttribute(ParameterName.NAME_TARIFF_PLAN, contract.getTariffPlanName());
            request.setAttribute(ParameterName.PRICE, contract.getTariffPlanPrice());
            request.setAttribute(ParameterName.INTERNET_CONNECTION_SPEED, contract.getTariffPlanSpeed());
            request.setAttribute(ParameterName.CONNECTION_DATE, contract.getConnectionDate());
            logger.info("The contract data has been successfully completed.");
            router = new Router(DISCONNECT_TARIFF);
        } catch (ServiceException e) {
            logger.error("The contract data hasn't been successfully completed.");
            router = new Router(ERROR_404);

        }

        return router;
    }
}
