package by.epam.finalTask.command.impl.admin;

import by.epam.finalTask.command.*;
import by.epam.finalTask.model.entity.TariffPlan;
import by.epam.finalTask.model.entity.User;
import by.epam.finalTask.model.service.impl.TariffPlanServiceImpl;
import com.google.protobuf.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static by.epam.finalTask.command.PageName.ERROR;
import static by.epam.finalTask.command.PageName.TARIFF_PLAN_MANAGEMENT;

public class SelectByNameTariffPlanCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        session.setAttribute(SessionAttribute.SESSION_USER,user);


        TariffPlanServiceImpl tariffPlanService = new TariffPlanServiceImpl();
        Optional<TariffPlan> tariffPlanOptional= null;

            try {
                tariffPlanOptional = tariffPlanService.findByNameTariffPlan(request.getParameter(ParameterName.NAME_TARIFF_PLAN));
                List<TariffPlan> tariffPlanList= tariffPlanOptional.isPresent()
                        ? Collections.singletonList(tariffPlanOptional.get())
                        : Collections.emptyList();;

                request.setAttribute("list", tariffPlanList);
                router = new Router(TARIFF_PLAN_MANAGEMENT.getPath());
            } catch (ServiceException e) {
                e.printStackTrace();
                router = new Router(ERROR.getPath());
            }
        return router;
    }
}
