package by.epam.task.controller.command.impl.page;

import by.epam.task.controller.command.Command;
import by.epam.task.controller.command.ParameterName;
import by.epam.task.controller.command.Router;
import by.epam.task.controller.command.SessionAttribute;
import by.epam.task.exception.CommandException;
import by.epam.task.exception.ServiceException;
import by.epam.task.model.entity.*;
import by.epam.task.model.service.impl.ContractServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.List;

import static by.epam.task.controller.command.PageName.*;

public class GoToTopUpBalanceCommand implements Command {

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        if(user == null || user.getUserRole().equals(UserRole.ADMIN) || !user.getUserStatus().equals(UserStatus.ACTIVE)) { return new Router(ERROR_404); }
        session.setAttribute(SessionAttribute.SESSION_USER,user);
        ContractServiceImpl contractService = new ContractServiceImpl();
        try {
            List<Contract> contractList = contractService.findAllContractByUserId(user.getUserId());
            Double totalCost = 0d;
            for (int i = 0 ; i < contractList.size(); i++){
                if(contractList.get(i).getContractStatus().equals(ContractStatus.CONNECTED)){
                totalCost =totalCost + Double.valueOf(String.valueOf(contractList.get(i).getTariffPlanPrice()));
                }
            }
            request.setAttribute(ParameterName.TOTAL_COAST, totalCost);
            request.setAttribute(ParameterName.DISCOUNT, user.getDiscount());
            request.setAttribute(ParameterName.BALANCE, user.getBalance());
            router = new Router(TOP_UP_BALANCE);
        } catch (ServiceException e) {
            router = new Router(ERROR_500);
        }
        return router;
    }
}
