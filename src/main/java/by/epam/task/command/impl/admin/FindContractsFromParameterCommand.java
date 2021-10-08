package by.epam.task.command.impl.admin;

import by.epam.task.command.*;
import by.epam.task.exception.*;
import by.epam.task.model.entity.Contract;
import by.epam.task.model.entity.User;
import by.epam.task.model.service.impl.ContractServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;

import static by.epam.task.command.PageName.*;

public class FindContractsFromParameterCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = null;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        session.setAttribute(SessionAttribute.SESSION_USER,user);
        ContractServiceImpl contractService = new ContractServiceImpl();
        List<Contract> contractList = null;
        switch (request.getParameter(ParameterName.FIELD)){
            case ParameterName.CONTRACT_ID:
               /* try{
                    contractList = contractService.findByContractId(request.getParameter(ParameterName.PARAMETER));
                    request.setAttribute(ParameterName.LIST, tariffPlanList);
                    router = new Router(TARIFF_PLAN_MANAGEMENT.getPath());
                } catch (ServiceException e) {
                    e.printStackTrace();
                    router = new Router(ERROR.getPath());
                }*/
                break;
            case ParameterName.TARIFF_PLAN_ID:
                    try {
                        contractList = contractService.findByTariffPlanId(Long.valueOf(request.getParameter(ParameterName.PARAMETER)));
                        request.setAttribute(ParameterName.LIST, contractList);
                        router = new Router(CONTRACT_MANAGEMENT);
                    } catch (ServiceException e) {
                        e.printStackTrace();
                        router = new Router(ERROR);
                    }
                break;
            case ParameterName.USER_ID:
                try {
                    contractList = contractService.findAllContractByUserId(Long.valueOf(request.getParameter(ParameterName.PARAMETER)));
                    request.setAttribute(ParameterName.LIST, contractList);
                    router = new Router(CONTRACT_MANAGEMENT);
                } catch (ServiceException e) {
                    e.printStackTrace();
                    router = new Router(ERROR);
                }
                break;
        }
        return router;
    }
}
