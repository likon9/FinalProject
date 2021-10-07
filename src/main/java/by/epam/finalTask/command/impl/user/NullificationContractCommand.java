package by.epam.finalTask.command.impl.user;

import by.epam.finalTask.command.*;
import by.epam.finalTask.exception.ServiceException;
import by.epam.finalTask.model.dao.ColumnName;
import by.epam.finalTask.model.entity.User;
import by.epam.finalTask.model.service.impl.ContractServiceImpl;
import by.epam.finalTask.util.IdGenerate;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import static by.epam.finalTask.command.PageName.ERROR;
import static by.epam.finalTask.command.PageName.HOME;

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
            request.setAttribute("message","Contract successfully disconnected");
            router = new Router(HOME.getPath());
        } catch (ServiceException e) {
            e.printStackTrace();
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
