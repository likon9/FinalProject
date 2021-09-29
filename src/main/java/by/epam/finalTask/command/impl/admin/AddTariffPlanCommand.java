package by.epam.finalTask.command.impl.admin;

import by.epam.finalTask.command.Command;
import by.epam.finalTask.command.CommandException;
import by.epam.finalTask.command.ParameterName;
import by.epam.finalTask.command.Router;
import by.epam.finalTask.model.service.impl.TariffPlanServiceImpl;
import by.epam.finalTask.util.IdGenerate;
import com.google.protobuf.ServiceException;
import jakarta.servlet.http.HttpServletRequest;

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
        newTariffPlan.put(NAME_TARIFF_PLAN, request.getParameter(ParameterName.NAME_TARIFF_PLAN));
        newTariffPlan.put(PRICE, request.getParameter(ParameterName.PRICE));
        newTariffPlan.put(INTERNET_CONNECTION_SPEED, request.getParameter(ParameterName.INTERNET_CONNECTION_SPEED));
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
