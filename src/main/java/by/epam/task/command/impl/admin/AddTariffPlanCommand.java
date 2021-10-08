package by.epam.task.command.impl.admin;

import by.epam.task.command.*;
import by.epam.task.exception.CommandException;
import by.epam.task.model.entity.User;
import by.epam.task.model.service.impl.TariffPlanServiceImpl;
import by.epam.task.util.IdGenerate;
import com.google.protobuf.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

import static by.epam.task.command.PageName.*;
import static by.epam.task.model.dao.ColumnName.*;

public class AddTariffPlanCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router;
        Map<String, String> newTariffPlan = new HashMap<>();
        newTariffPlan.put(TARIFF_PLAN_ID, String.valueOf(IdGenerate.generateId()));
        newTariffPlan.put(NAME_TARIFF_PLAN, request.getParameter(ParameterName.NAME_TARIFF_PLAN));
        newTariffPlan.put(PRICE, request.getParameter(ParameterName.PRICE));
        newTariffPlan.put(INTERNET_CONNECTION_SPEED, request.getParameter(ParameterName.INTERNET_CONNECTION_SPEED));
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        session.setAttribute(SessionAttribute.SESSION_USER,user);
        try{
            TariffPlanServiceImpl tariffPlanService = new TariffPlanServiceImpl();
            tariffPlanService.addTariffPlan(newTariffPlan);
            request.setAttribute(ParameterName.RES, "The tariff plan has been successfully added.");
            router = new Router(ADD_TARIFF_PLAN);
        }
        catch (ServiceException e) {
            router = new Router(ERROR);
            e.printStackTrace();
        }
        return router;
    }
}
