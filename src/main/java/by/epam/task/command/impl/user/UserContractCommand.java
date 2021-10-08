package by.epam.task.command.impl.user;

import by.epam.task.command.*;
import by.epam.task.exception.CommandException;
import by.epam.task.exception.ServiceException;
import by.epam.task.model.entity.Contract;
import by.epam.task.model.entity.User;
import by.epam.task.model.service.impl.ContractServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public class UserContractCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        session.setAttribute(SessionAttribute.SESSION_USER,user);
        ContractServiceImpl contractService = new ContractServiceImpl();
        try {
            List<Contract> contractList = contractService.findEffectiveContractByUserId(user.getUserId());
            request.setAttribute(ParameterName.LIST, contractList);
            router = new Router(PageName.USER_CONTRACT);
        } catch (ServiceException e) {

            router = new Router(PageName.ERROR);
        }
        return router;
    }
}
