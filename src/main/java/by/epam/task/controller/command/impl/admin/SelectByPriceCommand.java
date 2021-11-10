package by.epam.task.controller.command.impl.admin;

import by.epam.task.controller.command.*;
import by.epam.task.exception.CommandException;
import by.epam.task.model.entity.TariffPlan;
import by.epam.task.model.entity.User;
import by.epam.task.model.entity.UserRole;
import by.epam.task.model.service.impl.TariffPlanServiceImpl;
import by.epam.task.exception.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.List;

import static by.epam.task.controller.command.PageName.*;

public class SelectByPriceCommand implements Command {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        if(user == null || user.getUserRole().equals(UserRole.USER)) { return new Router(ERROR_404); }
        session.setAttribute(SessionAttribute.SESSION_USER,user);
        Double price = Double.valueOf(request.getParameter(ParameterName.PRICE));
        TariffPlanServiceImpl tariffPlanService = new TariffPlanServiceImpl();
        List<TariffPlan> tariffPlanList = null;
        try {
            tariffPlanList =tariffPlanService.findByPrice(BigDecimal.valueOf(price));
            request.setAttribute(ParameterName.LIST, tariffPlanList);
            logger.info("Successfully in viewing select by price tariff plans");
            router = new Router(TARIFF_PLAN_MANAGEMENT);
        } catch (ServiceException e) {
            logger.error("Error in viewing select by price tariff plans");
            router = new Router(ERROR_500);
        }
        return router;
    }
}

