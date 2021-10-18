package by.epam.task.controller.command.impl.admin;

import by.epam.task.controller.command.Command;
import by.epam.task.controller.command.ParameterName;
import by.epam.task.controller.command.Router;
import by.epam.task.controller.command.SessionAttribute;
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

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static by.epam.task.controller.command.PageName.*;

public class SelectByNameTariffPlanCommand implements Command {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        if(user == null || user.getUserStatus().equals(UserRole.USER)) { return new Router(ERROR_404); }
        session.setAttribute(SessionAttribute.SESSION_USER,user);
        TariffPlanServiceImpl tariffPlanService = new TariffPlanServiceImpl();
        Optional<TariffPlan> tariffPlanOptional= null;
            try {
                tariffPlanOptional = tariffPlanService.findByNameTariffPlan(request.getParameter(ParameterName.NAME_TARIFF_PLAN));
                List<TariffPlan> tariffPlanList= tariffPlanOptional.isPresent()
                        ? Collections.singletonList(tariffPlanOptional.get())
                        : Collections.emptyList();;
                request.setAttribute(ParameterName.LIST, tariffPlanList);
                logger.info("Successfully in viewing select by name tariff plans");
                router = new Router(TARIFF_PLAN_MANAGEMENT);
            } catch (ServiceException e) {
                logger.error("Error in viewing select by name tariff plans");
                router = new Router(ERROR_500);
            }
        return router;
    }
}
