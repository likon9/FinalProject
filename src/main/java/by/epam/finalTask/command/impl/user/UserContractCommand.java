package by.epam.finalTask.command.impl.user;

import by.epam.finalTask.command.Command;
import by.epam.finalTask.command.CommandException;
import by.epam.finalTask.command.PageName;
import by.epam.finalTask.command.SessionAttribute;
import by.epam.finalTask.exception.ServiceException;
import by.epam.finalTask.model.entity.Contract;
import by.epam.finalTask.model.entity.User;
import by.epam.finalTask.model.service.impl.ContractServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public class UserContractCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page = null;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        session.setAttribute(SessionAttribute.SESSION_USER,user);
        ContractServiceImpl contractService = new ContractServiceImpl();
        try {
            List<Contract> contractList = contractService.findContractByUserId(user.getUserId());
            request.setAttribute("list", contractList);
            page = PageName.USER_CONTRACT.getPath();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return page;
    }
}
