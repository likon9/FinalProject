package by.epam.task.controller.command.impl.admin;

import by.epam.task.controller.command.*;
import by.epam.task.exception.CommandException;
import by.epam.task.model.dao.ColumnName;
import by.epam.task.model.entity.TariffPlan;
import by.epam.task.model.entity.User;
import by.epam.task.model.entity.UserRole;
import by.epam.task.model.service.impl.TariffPlanServiceImpl;
import by.epam.task.exception.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.epam.task.controller.command.PageName.*;
import static by.epam.task.controller.command.ParameterName.*;

public class UpdateTariffPlanCommand implements Command {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        if(user == null || user.getUserRole().equals(UserRole.USER)) { return new Router(ERROR_404); }
        session.setAttribute(SessionAttribute.SESSION_USER,user);
        Long id  = Long.valueOf(request.getParameter(ParameterName.TARIFF_PLAN_ID));
        String select = request.getParameter(ParameterName.SELECT);
        String attribute = request.getParameter(ParameterName.ATTRIBUTE);

        TariffPlanServiceImpl tariffPlanService = new TariffPlanServiceImpl();
        Map<String, String> parameter = new HashMap<>();
        parameter.put(ParameterName.SELECT, attribute);

        switch (select){
            case ParameterName.NAME_TARIFF_PLAN:
            parameter.put(ColumnName.NAME_TARIFF_PLAN, attribute);
                try {
                    tariffPlanService.updateNameTariffPlan(parameter,id);
                    request.setAttribute(RES_TARIFF_UPDATE_TRUE,true);
                    logger.info("Successfully update name tariff plan");
                } catch (ServiceException e) {
                    request.setAttribute(RES_TARIFF_UPDATE_FALSE,true);
                    logger.error("Error update name tariff plan" + e);
                }
                break;
            case ParameterName.PRICE:
                parameter.put(ColumnName.PRICE, attribute);
                try {
                    tariffPlanService.updatePrice(parameter,id);
                    request.setAttribute(RES_TARIFF_UPDATE_TRUE,true);
                    logger.info("Successfully update price tariff plan");
                } catch (ServiceException e) {
                    request.setAttribute(RES_TARIFF_UPDATE_FALSE,true);
                    logger.error("Error update price tariff plan" + e);
                }
                break;
            case ParameterName.INTERNET_CONNECTION_SPEED:
                parameter.put(ColumnName.INTERNET_CONNECTION_SPEED, attribute);
                try {
                    tariffPlanService.updateInternetConnectionSpeed(parameter,id);
                    request.setAttribute(RES_TARIFF_UPDATE_TRUE,true);
                    logger.info("Successfully update internet speed tariff plan");
                } catch (ServiceException e) {
                    request.setAttribute(RES_TARIFF_UPDATE_FALSE,true);
                    logger.error("Error update internet speed tariff plan" + e);
                }
                break;
        }
        List<TariffPlan> tariffPlanList = null;
        try {
            tariffPlanList = tariffPlanService.findAllTariffPlan();
            request.setAttribute(ParameterName.LIST, tariffPlanList);
            router = new Router(TARIFF_PLAN_MANAGEMENT);
        } catch (ServiceException e) {
            logger.error("Error update tariff plan" + e);
            router = new Router(ERROR_500);
        }
        return router;
    }
}
