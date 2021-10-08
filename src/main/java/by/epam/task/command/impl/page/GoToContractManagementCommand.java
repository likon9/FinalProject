package by.epam.task.command.impl.page;

import by.epam.task.command.*;
import by.epam.task.exception.CommandException;
import by.epam.task.exception.ServiceException;
import by.epam.task.model.entity.Contract;
import by.epam.task.model.entity.User;
import by.epam.task.model.service.impl.ContractServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;

import static by.epam.task.command.PageName.*;

public class GoToContractManagementCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        session.setAttribute(SessionAttribute.SESSION_USER,user);
        ContractServiceImpl contractService = new ContractServiceImpl();
        List<Contract> contractList = null;
        try {
            contractList = contractService.findAll();
            request.setAttribute(ParameterName.LIST,contractList);
            router = new Router(CONTRACT_MANAGEMENT);
        } catch (ServiceException e) {
            e.printStackTrace();
            router = new Router(ERROR);

        }
        return router;
    }
}