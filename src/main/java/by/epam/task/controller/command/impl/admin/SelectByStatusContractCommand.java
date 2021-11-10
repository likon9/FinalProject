package by.epam.task.controller.command.impl.admin;

import by.epam.task.controller.command.*;
import by.epam.task.exception.CommandException;
import by.epam.task.exception.ServiceException;
import by.epam.task.model.entity.Contract;
import by.epam.task.model.entity.ContractStatus;
import by.epam.task.model.entity.User;
import by.epam.task.model.entity.UserRole;
import by.epam.task.model.service.impl.ContractServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static by.epam.task.controller.command.PageName.*;
import static by.epam.task.controller.command.ParameterName.*;

public class SelectByStatusContractCommand implements Command {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = null;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        if(user == null || user.getUserRole().equals(UserRole.USER)) { return new Router(ERROR_404); }
        session.setAttribute(SessionAttribute.SESSION_USER,user);
        List<Contract> contractList = null;
        ContractServiceImpl contractService = new ContractServiceImpl();
        System.out.println(request.getParameter(ParameterName.SELECT));
        switch (request.getParameter(ParameterName.SELECT)){
            case ALL_CONTRACTS:
                try {
                    contractList = contractService.findAll();
                    request.setAttribute(LIST, contractList);
                    logger.info("Successfully in viewing all contracts");
                    router = new Router(CONTRACT_MANAGEMENT);
                } catch (ServiceException e) {
                    logger.error("Error in viewing all contracts" + e);
                    router = new Router(ERROR_500);
                }
                break;
            case CONNECTED_CONTRACTS:
                try {
                    contractList = contractService.findByStatus(String.valueOf((ContractStatus.CONNECTED)));
                    request.setAttribute(LIST, contractList);
                    logger.info("Successfully in viewing connected contracts");
                    router = new Router(CONTRACT_MANAGEMENT);
                } catch (ServiceException e) {
                    logger.error("Error in viewing connected contracts" + e);
                    router = new Router(ERROR_500);
                }
                break;
            case DISCONNECTED_CONTRACTS:
                try {
                    contractList = contractService.findByStatus(String.valueOf(ContractStatus.DISCONNECTED));
                    request.setAttribute(LIST, contractList);
                    logger.info("Successfully in viewing disconnected contracts");
                    router = new Router(CONTRACT_MANAGEMENT);
                } catch (by.epam.task.exception.ServiceException e) {
                    logger.error("Error in viewing disconnected contracts" + e);
                    router = new Router(ERROR_500);
                }
                break;
        }
        return router;
    }
}
