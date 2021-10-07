package by.epam.finalTask.command.impl.admin;

import by.epam.finalTask.command.*;
import by.epam.finalTask.model.entity.Contract;
import by.epam.finalTask.model.entity.TariffPlan;
import by.epam.finalTask.model.entity.User;
import by.epam.finalTask.model.service.impl.ContractServiceImpl;
import by.epam.finalTask.model.service.impl.TariffPlanServiceImpl;
import com.google.protobuf.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;

import static by.epam.finalTask.command.PageName.*;

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
                        router = new Router(CONTRACT_MANAGEMENT.getPath());
                    } catch (by.epam.finalTask.exception.ServiceException e) {
                        e.printStackTrace();
                        router = new Router(ERROR.getPath());
                    }
                break;
            case ParameterName.USER_ID:
                try {
                    contractList = contractService.findAllContractByUserId(Long.valueOf(request.getParameter(ParameterName.PARAMETER)));
                    request.setAttribute(ParameterName.LIST, contractList);
                    router = new Router(CONTRACT_MANAGEMENT.getPath());
                } catch (by.epam.finalTask.exception.ServiceException e) {
                    e.printStackTrace();
                    router = new Router(ERROR.getPath());
                }
                break;
        }

        return router;
    }
}
