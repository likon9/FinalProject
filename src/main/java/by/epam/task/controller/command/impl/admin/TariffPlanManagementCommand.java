package by.epam.task.controller.command.impl.admin;

import by.epam.task.controller.command.Command;
import by.epam.task.controller.command.ParameterName;
import by.epam.task.exception.CommandException;
import by.epam.task.controller.command.Router;
import by.epam.task.controller.command.SessionAttribute;
import by.epam.task.model.entity.TariffPlan;
import by.epam.task.model.entity.User;
import by.epam.task.model.service.impl.TariffPlanServiceImpl;
import com.google.protobuf.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static by.epam.task.controller.command.PageName.*;

public class TariffPlanManagementCommand implements Command {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        session.setAttribute(SessionAttribute.SESSION_USER,user);
        TariffPlanServiceImpl tariffPlanService = new TariffPlanServiceImpl();
        List<TariffPlan> tariffPlanList = null;
        try{
            tariffPlanList = tariffPlanService.findAllTariffPlan();
            request.setAttribute(ParameterName.LIST, tariffPlanList);
            logger.info("Successfully in viewing tariff plans");
            router = new Router(TARIFF_PLAN_MANAGEMENT);
        } catch (ServiceException e) {
            logger.error("Error in viewing tariff plans");
            router = new Router(ERROR_500);
        }
        return router;
    }
}