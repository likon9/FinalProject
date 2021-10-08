package by.epam.task.command.impl.admin;

import by.epam.task.command.*;
import by.epam.task.exception.CommandException;
import by.epam.task.exception.ServiceException;
import by.epam.task.model.entity.Contract;
import by.epam.task.model.entity.ContractStatus;
import by.epam.task.model.entity.User;
import by.epam.task.model.service.impl.ContractServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;

import static by.epam.task.command.PageName.*;
import static by.epam.task.command.ParameterName.*;

public class SelectByStatusContractCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = null;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        session.setAttribute(SessionAttribute.SESSION_USER,user);
        List<Contract> contractList = null;
        ContractServiceImpl contractService = new ContractServiceImpl();

        switch (request.getParameter(ParameterName.SELECT)){
            case ALL_CONTRACTS:
                try {
                    contractList = contractService.findAll();
                    request.setAttribute(LIST, contractList);
                    router = new Router(CONTRACT_MANAGEMENT);
                } catch (ServiceException e) {
                    e.printStackTrace();
                }
                break;
            case CONNECTED_CONTRACTS:
                try {
                    contractList = contractService.findByStatus(String.valueOf((ContractStatus.CONNECTED)));
                    request.setAttribute(LIST, contractList);
                    router = new Router(CONTRACT_MANAGEMENT);
                } catch (ServiceException e) {
                    router = new Router(ERROR);
                    e.printStackTrace();
                }
                break;
            case DISCONNECTED_CONTRACTS:
                try {
                    contractList = contractService.findByStatus(String.valueOf(ContractStatus.DISCONNECTED));
                    request.setAttribute(LIST, contractList);
                    router = new Router(CONTRACT_MANAGEMENT);
                } catch (by.epam.task.exception.ServiceException e) {
                    e.printStackTrace();
                }
                break;
            default:
                router = new Router(ERROR);
                break;
        }
        return router;
    }
}
