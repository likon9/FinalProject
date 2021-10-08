package by.epam.task.command.impl.admin;

import by.epam.task.command.*;
import by.epam.task.exception.CommandException;
import by.epam.task.model.dao.ColumnName;
import by.epam.task.model.entity.TariffPlan;
import by.epam.task.model.entity.User;
import by.epam.task.model.service.impl.TariffPlanServiceImpl;
import com.google.protobuf.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.epam.task.command.PageName.*;
import static by.epam.task.command.ParameterName.RES;

public class UpdateTariffPlanCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
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
                    router = new Router(PageName.TARIFF_PLAN_MANAGEMENT);
                    request.setAttribute(RES,"The tariff plan has been successfully changed");
                } catch (ServiceException e) {
                    e.printStackTrace();
                    router = new Router(PageName.TARIFF_PLAN_MANAGEMENT);
                    request.setAttribute(RES,"The tariff plan has not been changed");
                }
                break;
            case ParameterName.PRICE:
                parameter.put(ColumnName.PRICE, attribute);
                try {
                    tariffPlanService.updatePrice(parameter,id);
                    router = new Router(PageName.TARIFF_PLAN_MANAGEMENT);
                    request.setAttribute(RES,"The tariff plan has been successfully changed");
                } catch (ServiceException e) {
                    e.printStackTrace();
                    router = new Router(PageName.TARIFF_PLAN_MANAGEMENT);
                    request.setAttribute(RES,"The tariff plan has not been changed");
                }
                break;
            case ParameterName.INTERNET_CONNECTION_SPEED:
                parameter.put(ColumnName.INTERNET_CONNECTION_SPEED, attribute);
                try {
                    tariffPlanService.updateInternetConnectionSpeed(parameter,id);
                    router = new Router(PageName.TARIFF_PLAN_MANAGEMENT);
                    request.setAttribute(RES,"The tariff plan has been successfully changed");
                } catch (ServiceException e) {
                    e.printStackTrace();
                    router = new Router(PageName.TARIFF_PLAN_MANAGEMENT);
                    request.setAttribute(RES,"The tariff plan has not been changed");
                }
                break;
        }
        List<TariffPlan> tariffPlanList = null;
        try {
            tariffPlanList = tariffPlanService.findAllTariffPlan();
            request.setAttribute(ParameterName.LIST, tariffPlanList);
            router = new Router(TARIFF_PLAN_MANAGEMENT);
        } catch (ServiceException e) {
            e.printStackTrace();
            router = new Router(ERROR);
        }
        return router;
    }
}
