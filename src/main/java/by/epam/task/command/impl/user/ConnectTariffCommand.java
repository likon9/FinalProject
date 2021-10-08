package by.epam.task.command.impl.user;

import by.epam.task.command.*;
import by.epam.task.exception.CommandException;
import by.epam.task.exception.ServiceException;
import by.epam.task.model.dao.ColumnName;
import by.epam.task.model.entity.User;
import by.epam.task.model.service.impl.ContractServiceImpl;
import by.epam.task.util.IdGenerate;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import static by.epam.task.command.PageName.*;

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
        parameters.put(ColumnName.CONTRACT_TARIFF_PLAN_ID, (request.getParameter(ParameterName.TARIFF_PLAN_ID)));
        try {
            contractService.addContract(parameters);
            request.setAttribute(ParameterName.MESSAGE,"Contract successfully concluded");
            router = new Router(HOME);
        } catch (ServiceException e) {
            router = new Router(ERROR);

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
