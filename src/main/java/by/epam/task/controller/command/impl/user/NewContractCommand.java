package by.epam.task.controller.command.impl.user;

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

import static by.epam.task.controller.command.PageName.*;

public class NewContractCommand implements Command {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        if(user == null || user.getUserStatus().equals(UserRole.ADMIN)) { return new Router(ERROR_404); }
        session.setAttribute(SessionAttribute.SESSION_USER,user);
        TariffPlanServiceImpl tariffPlanService = new TariffPlanServiceImpl();
        TariffPlan tariffPlan = null;
        try {
            tariffPlan = tariffPlanService.findByIdTariffPlan(Long.parseLong(request.getParameter(ParameterName.TARIFF_PLAN_ID))).get();
            request.setAttribute(ParameterName.LOGIN, user.getLogin());
            request.setAttribute(ParameterName.EMAIL, user.getEmail());
            request.setAttribute(ParameterName.NAME, user.getName());
            request.setAttribute(ParameterName.SURNAME, user.getSurname());
            request.setAttribute(ParameterName.PHONE, user.getPhone());
            request.setAttribute(ParameterName.NAME_TARIFF_PLAN, tariffPlan.getNameTariffPlan());
            request.setAttribute(ParameterName.PRICE, tariffPlan.getPrice());
            request.setAttribute(ParameterName.INTERNET_CONNECTION_SPEED,tariffPlan.getInternetConnectionSpeed());
            request.setAttribute(ParameterName.TARIFF_PLAN_ID,tariffPlan.getTariffPlanId());
            logger.info("The contract data has been successfully completed.");
            router = new Router(CONNECT_TARIFF);
        } catch (ServiceException e) {
            logger.error("The contract data hasn't been successfully completed." + e);
            router = new Router(ERROR_500);
        }
        return router;
    }
}
