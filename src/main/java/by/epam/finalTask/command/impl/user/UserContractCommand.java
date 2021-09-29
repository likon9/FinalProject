package by.epam.finalTask.command.impl.user;

import by.epam.finalTask.command.*;
import by.epam.finalTask.exception.ServiceException;
import by.epam.finalTask.model.entity.Contract;
import by.epam.finalTask.model.entity.User;
import by.epam.finalTask.model.service.impl.ContractServiceImpl;
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
            List<Contract> contractList = contractService.findContractByUserId(user.getUserId());
            request.setAttribute("list", contractList);
            router = new Router(PageName.USER_CONTRACT.getPath());
        } catch (ServiceException e) {
            e.printStackTrace();
            router = new Router(PageName.ERROR.getPath());
        }
        return router;
    }
}
