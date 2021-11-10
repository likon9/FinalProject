package by.epam.task.controller.command.impl.user;

import by.epam.task.controller.command.*;
import by.epam.task.exception.CommandException;
import by.epam.task.exception.ServiceException;
import by.epam.task.model.entity.Contract;
import by.epam.task.model.entity.User;
import by.epam.task.model.entity.UserRole;
import by.epam.task.model.entity.UserStatus;
import by.epam.task.model.service.impl.ContractServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.List;

import static by.epam.task.controller.command.PageName.ERROR_404;
import static by.epam.task.controller.command.PageName.ERROR_500;

public class UserContractCommand implements Command {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        if(user == null || user.getUserRole().equals(UserRole.ADMIN) || !user.getUserStatus().equals(UserStatus.ACTIVE)) { return new Router(ERROR_404); }
        session.setAttribute(SessionAttribute.SESSION_USER,user);
        ContractServiceImpl contractService = new ContractServiceImpl();
        try {
            List<Contract> contractList = contractService.findEffectiveContractByUserId(user.getUserId());
            request.setAttribute(ParameterName.LIST, contractList);
            logger.info("Successfully in viewing contracts");
            router = new Router(PageName.USER_CONTRACT);
        } catch (ServiceException e) {
            logger.error("Error in viewing contracts" + e);
            router = new Router(ERROR_500);
        }
        return router;
    }
}
