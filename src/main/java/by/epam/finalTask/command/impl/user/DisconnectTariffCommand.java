package by.epam.finalTask.command.impl.user;

import by.epam.finalTask.command.*;
import by.epam.finalTask.exception.ServiceException;
import by.epam.finalTask.model.entity.Contract;
import by.epam.finalTask.model.entity.User;
import by.epam.finalTask.model.service.impl.ContractServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import static by.epam.finalTask.command.PageName.DISCONNECT_TARIFF;

public class DisconnectTariffCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        session.setAttribute(SessionAttribute.SESSION_USER,user);


        ContractServiceImpl contractService = new ContractServiceImpl();
        Contract contract = null;
        try {
            contract = contractService.findByContractId(Long.parseLong(request.getParameter(ParameterName.CONTRACT_ID))).get();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        request.setAttribute(ParameterName.CONTRACT_ID, contract.getContractId());
        request.setAttribute(ParameterName.NAME_TARIFF_PLAN, contract.getTariffPlanName());
        request.setAttribute(ParameterName.PRICE, contract.getTariffPlanPrice());
        request.setAttribute(ParameterName.INTERNET_CONNECTION_SPEED, contract.getTariffPlanSpeed());
        request.setAttribute(ParameterName.CONNECTION_DATE, contract.getConnectionDate());



        Router router = new Router(DISCONNECT_TARIFF.getPath());
        return router;
    }
}
