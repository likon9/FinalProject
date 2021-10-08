package by.epam.task.command.impl.user;

import by.epam.task.command.*;
import by.epam.task.exception.CommandException;
import by.epam.task.model.entity.TariffPlan;
import by.epam.task.model.entity.User;
import by.epam.task.model.service.impl.TariffPlanServiceImpl;
import com.google.protobuf.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import static by.epam.task.command.PageName.CONNECT_TARIFF;

public class NewContractCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        session.setAttribute(SessionAttribute.SESSION_USER,user);
        TariffPlanServiceImpl tariffPlanService = new TariffPlanServiceImpl();
        TariffPlan tariffPlan = null;
        try {
           tariffPlan = tariffPlanService.findByIdTariffPlan(Long.parseLong(request.getParameter(ParameterName.TARIFF_PLAN_ID))).get();
        } catch (ServiceException e) {
        }
        request.setAttribute(ParameterName.LOGIN, user.getLogin());
        request.setAttribute(ParameterName.EMAIL, user.getEmail());
        request.setAttribute(ParameterName.NAME, user.getName());
        request.setAttribute(ParameterName.SURNAME, user.getSurname());
        request.setAttribute(ParameterName.PHONE, user.getPhone());
        request.setAttribute(ParameterName.NAME_TARIFF_PLAN, tariffPlan.getNameTariffPlan());
        request.setAttribute(ParameterName.PRICE, tariffPlan.getPrice());
        request.setAttribute(ParameterName.INTERNET_CONNECTION_SPEED,tariffPlan.getInternetConnectionSpeed());
        request.setAttribute(ParameterName.TARIFF_PLAN_ID,tariffPlan.getTariffPlanId());
        Router router = new Router(CONNECT_TARIFF);
        return router;
    }
}
