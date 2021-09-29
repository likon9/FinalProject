package by.epam.finalTask.command.impl.admin;

import by.epam.finalTask.command.*;
import by.epam.finalTask.model.entity.TariffPlan;
import by.epam.finalTask.model.entity.User;
import by.epam.finalTask.model.service.impl.TariffPlanServiceImpl;
import com.google.protobuf.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;

import static by.epam.finalTask.command.PageName.ERROR;
import static by.epam.finalTask.command.PageName.TARIFF_PLAN_MANAGEMENT;

public class SelectByInternetConnectionSpeedCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        session.setAttribute(SessionAttribute.SESSION_USER,user);

        int internetSpeed = Integer.parseInt(request.getParameter(ParameterName.INTERNET_CONNECTION_SPEED));
        TariffPlanServiceImpl tariffPlanService = new TariffPlanServiceImpl();
        List<TariffPlan> tariffPlanList = null;
        try {
            tariffPlanList =tariffPlanService.findByInternetConnectionSpeed(internetSpeed);
            request.setAttribute("list", tariffPlanList);
            router = new Router(TARIFF_PLAN_MANAGEMENT.getPath());
        } catch (ServiceException e) {
            e.printStackTrace();
            router = new Router(ERROR.getPath());
        }
        return router;
    }
}

