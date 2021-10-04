package by.epam.finalTask.command.impl.user;

import by.epam.finalTask.command.*;
import by.epam.finalTask.exception.DaoException;
import by.epam.finalTask.model.dao.ColumnName;
import by.epam.finalTask.model.dao.TariffPlanDao;
import by.epam.finalTask.model.entity.TariffPlan;
import by.epam.finalTask.model.entity.User;
import by.epam.finalTask.model.service.impl.ContractServiceImpl;
import by.epam.finalTask.model.service.impl.TariffPlanServiceImpl;
import by.epam.finalTask.util.IdGenerate;
import com.google.protobuf.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import static by.epam.finalTask.command.PageName.*;

public class ConnectTariffCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        session.setAttribute(SessionAttribute.SESSION_USER,user);
        ContractServiceImpl contractService = new ContractServiceImpl();

        Map<String, String> parameters = new HashMap<>();
        parameters.put(ColumnName.CONTRACT_ID, String.valueOf(IdGenerate.generateId()));
        parameters.put(ColumnName.CONNECTION_DATE, String.valueOf(Timestamp.from(Instant.now())));
        parameters.put(ColumnName.CONTRACT_USER_ID, String.valueOf(user.getUserId()));
        parameters.put(ColumnName.CONTRACT_TARIFF_PLAN_ID, (request.getParameter(ParameterName.ID_TARIFF_PLAN)));
        try {
            contractService.addContract(parameters);
            request.setAttribute("message","Contract successfully concluded");
            router = new Router(HOME.getPath());
        } catch (by.epam.finalTask.exception.ServiceException e) {
            e.printStackTrace();
            router = new Router(ERROR.getPath());

        }
        request.setAttribute(ParameterName.LOGIN, user.getLogin());
        request.setAttribute(ParameterName.EMAIL, user.getEmail());
        request.setAttribute(ParameterName.NAME, user.getName());
        request.setAttribute(ParameterName.SURNAME, user.getSurname());
        request.setAttribute(ParameterName.PHONE, user.getPhone());
        session.setAttribute(SessionAttribute.SESSION_USER,user);
        return router;
    }
}
