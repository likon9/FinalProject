package by.epam.finalTask.command.impl.admin;

import by.epam.finalTask.command.*;
import by.epam.finalTask.model.entity.User;
import by.epam.finalTask.model.service.impl.TariffPlanServiceImpl;
import by.epam.finalTask.util.IdGenerate;
import com.google.protobuf.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

import static by.epam.finalTask.command.PageName.*;
import static by.epam.finalTask.model.dao.ColumnName.*;

public class AddTariffPlanCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router;
        Map<String, String> newTariffPlan = new HashMap<>();
        newTariffPlan.put(TARIFF_PLAN_ID, String.valueOf(IdGenerate.generateId()));
        System.out.println("123"+request.getParameter(ParameterName.NAME_TARIFF_PLAN+request.getParameter(ParameterName.PRICE)));
        newTariffPlan.put(NAME_TARIFF_PLAN, request.getParameter(ParameterName.NAME_TARIFF_PLAN));
        newTariffPlan.put(PRICE, request.getParameter(ParameterName.PRICE));
        newTariffPlan.put(INTERNET_CONNECTION_SPEED, request.getParameter(ParameterName.INTERNET_CONNECTION_SPEED));
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        session.setAttribute(SessionAttribute.SESSION_USER,user);

        try{
            TariffPlanServiceImpl tariffPlanService = new TariffPlanServiceImpl();
            tariffPlanService.addTariffPlan(newTariffPlan);
            request.setAttribute("res", "The tariff plan has been successfully added.");
            router = new Router(ADD_TARIFF_PLAN.getPath());
        }
        catch (ServiceException e) {
            router = new Router(ERROR.getPath());
            e.printStackTrace();
        }
        return router;
    }
}
