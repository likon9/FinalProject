package by.epam.task.controller.command.impl.admin;

import by.epam.task.controller.command.*;
import by.epam.task.exception.*;
import by.epam.task.model.entity.Contract;
import by.epam.task.model.entity.User;
import by.epam.task.model.entity.UserRole;
import by.epam.task.model.service.impl.ContractServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static by.epam.task.controller.command.PageName.*;

public class FindContractsFromParameterCommand implements Command {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = null;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        if(user == null || user.getUserRole().equals(UserRole.USER)) { return new Router(ERROR_404); }
        session.setAttribute(SessionAttribute.SESSION_USER,user);
        ContractServiceImpl contractService = new ContractServiceImpl();
        List<Contract> contractList = null;
        switch (request.getParameter(ParameterName.FIELD)){
            case ParameterName.CONTRACT_ID:
                try{
                    Optional<Contract> contractOptional= null;
                    contractOptional = contractService.findByContractId(Long.valueOf(request.getParameter(ParameterName.PARAMETER)));
                    contractList = contractOptional.isPresent()
                            ? Collections.singletonList(contractOptional.get())
                            : Collections.emptyList();
                    request.setAttribute(ParameterName.LIST, contractList);
                    logger.info("Successfully found contract by contract id");
                    router = new Router(CONTRACT_MANAGEMENT);
                } catch (ServiceException e) {
                    logger.error("Error found contract by contract id" + e);
                    router = new Router(ERROR_500);
                }
                break;
            case ParameterName.TARIFF_PLAN_ID:
                    try {
                        contractList = contractService.findByTariffPlanId(Long.valueOf(request.getParameter(ParameterName.PARAMETER)));
                        request.setAttribute(ParameterName.LIST, contractList);
                        logger.info("Successfully found contracts by tariff plan id");
                        router = new Router(CONTRACT_MANAGEMENT);
                    } catch (ServiceException e) {
                        logger.error("Error found contracts by tariff plan id" + e);
                        router = new Router(ERROR_500);
                    }
                break;
            case ParameterName.USER_ID:
                try {
                    contractList = contractService.findAllContractByUserId(Long.valueOf(request.getParameter(ParameterName.PARAMETER)));
                    request.setAttribute(ParameterName.LIST, contractList);
                    logger.info("Successfully found contracts by user id");
                    router = new Router(CONTRACT_MANAGEMENT);
                } catch (ServiceException e) {
                    logger.error("Error found contracts by user id + e");
                    router = new Router(ERROR_500);
                }
                break;
        }
        return router;
    }
}
