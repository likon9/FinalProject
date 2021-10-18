package by.epam.task.controller.command.impl.admin;

import by.epam.task.controller.command.Command;
import by.epam.task.controller.command.ParameterName;
import by.epam.task.controller.command.Router;
import by.epam.task.controller.command.SessionAttribute;
import by.epam.task.exception.CommandException;
import by.epam.task.model.entity.User;
import by.epam.task.model.entity.UserRole;
import by.epam.task.model.service.impl.TariffPlanServiceImpl;
import by.epam.task.exception.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

import static by.epam.task.controller.command.PageName.*;
import static by.epam.task.model.dao.ColumnName.*;

public class AddTariffPlanCommand implements Command {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router;

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        if(user == null || user.getUserStatus().equals(UserRole.USER)) { return new Router(ERROR_404); }
        Map<String, String> newTariffPlan = new HashMap<>();
        newTariffPlan.put(NAME_TARIFF_PLAN, request.getParameter(ParameterName.NAME_TARIFF_PLAN));
        newTariffPlan.put(PRICE, request.getParameter(ParameterName.PRICE));
        newTariffPlan.put(INTERNET_CONNECTION_SPEED, request.getParameter(ParameterName.INTERNET_CONNECTION_SPEED));
        session.setAttribute(SessionAttribute.SESSION_USER,user);
        TariffPlanServiceImpl tariffPlanService = new TariffPlanServiceImpl();
        try{
            tariffPlanService.addTariffPlan(newTariffPlan);
            request.setAttribute(ParameterName.RES_ADD_TARIFF_TRUE, true);
            logger.info("Successfully add tariff plan");
            router = new Router(ADD_TARIFF_PLAN);
        }
        catch (ServiceException e) {
            request.setAttribute(ParameterName.RES_ADD_TARIFF_FALSE, true);
            logger.error("Error add tariff plan");
            router = new Router(ADD_TARIFF_PLAN);
        }
        return router;
    }
}
