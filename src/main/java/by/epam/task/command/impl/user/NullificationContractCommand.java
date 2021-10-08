package by.epam.task.command.impl.user;

import by.epam.task.command.*;
import by.epam.task.exception.CommandException;
import by.epam.task.exception.ServiceException;
import by.epam.task.model.dao.ColumnName;
import by.epam.task.model.entity.User;
import by.epam.task.model.service.impl.ContractServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

import static by.epam.task.command.PageName.ERROR;
import static by.epam.task.command.PageName.HOME;

public class NullificationContractCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = null;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        session.setAttribute(SessionAttribute.SESSION_USER,user);
        Map<String, String> parameters = new HashMap<>();
        parameters.put(ColumnName.CONTRACT_STATUS, String.valueOf(2));
        ContractServiceImpl contractService = new ContractServiceImpl();
        try {
            contractService.updateStatusContract(parameters, Long.valueOf(request.getParameter(ParameterName.CONTRACT_ID)));
            request.setAttribute(ParameterName.MESSAGE,"Contract successfully disconnected");
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
