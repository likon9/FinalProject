package by.epam.task.controller.command.impl.admin.userManagement;

import by.epam.task.controller.command.Command;
import by.epam.task.controller.command.ParameterName;
import by.epam.task.controller.command.Router;
import by.epam.task.controller.command.SessionAttribute;
import by.epam.task.exception.CommandException;
import by.epam.task.exception.ServiceException;
import by.epam.task.model.dao.ColumnName;
import by.epam.task.model.entity.Contract;
import by.epam.task.model.entity.ContractStatus;
import by.epam.task.model.entity.User;
import by.epam.task.model.entity.UserRole;
import by.epam.task.model.service.impl.ContractServiceImpl;
import by.epam.task.model.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static by.epam.task.controller.command.PageName.*;

public class WriteOfAccountCommand implements Command {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        if(user == null || user.getUserRole().equals(UserRole.USER)) { return new Router(ERROR_404); }
        session.setAttribute(SessionAttribute.SESSION_USER, user);
        String id = request.getParameter(ParameterName.USER_ID);
        UserServiceImpl userService = new UserServiceImpl();
        Optional<User> userOptional = null;
        try {
            userOptional = userService.findById(Long.valueOf(id));
        } catch (ServiceException e) {
            router = new Router(ERROR_500);
        }
        Double balance = Double.valueOf(String.valueOf(userOptional.get().getBalance()));
        Double discount = Double.valueOf(String.valueOf(userOptional.get().getDiscount()));
        Double totalCost = 0d;
        ContractServiceImpl contractService = new ContractServiceImpl();
        try {
            List<Contract> contractList = contractService.findAllContractByUserId(Long.valueOf(id));
            System.out.println(contractList);
            for (int i = 0; i < contractList.size(); i++) {
                if (contractList.get(i).getContractStatus().equals(ContractStatus.CONNECTED)) {
                    totalCost = totalCost + Double.valueOf(String.valueOf(contractList.get(i).getTariffPlanPrice()));
                }
            }
            balance = balance - (totalCost-totalCost*discount);
            Map<String, String> userParameter = new HashMap<>();
            userParameter.put(ColumnName.BALANCE, String.valueOf(balance));
            userService.updateBalance(userParameter, Long.valueOf(id));
            List<User> userList = null;
            userList = userService.findAll();
            request.setAttribute(ParameterName.LIST, userList);
            request.setAttribute(ParameterName.RES_WRITE_TRUE, true);
            logger.info("Successfully write of account");
            router = new Router(USER_LIST);
        } catch (ServiceException e) {
            logger.error("Error write of account" + e);
            router = new Router(ERROR_500);
        }
        return router;
    }
}