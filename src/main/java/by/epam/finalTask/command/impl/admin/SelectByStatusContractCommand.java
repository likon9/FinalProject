package by.epam.finalTask.command.impl.admin;

import by.epam.finalTask.command.*;
import by.epam.finalTask.model.entity.Contract;
import by.epam.finalTask.model.entity.ContractStatus;
import by.epam.finalTask.model.entity.User;
import by.epam.finalTask.model.entity.UserStatus;
import by.epam.finalTask.model.service.impl.ContractServiceImpl;
import com.google.protobuf.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;

import static by.epam.finalTask.command.PageName.*;
import static by.epam.finalTask.command.ParameterName.*;
import static by.epam.finalTask.command.ParameterName.DELETED_USERS;

public class SelectByStatusContractCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = null;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        session.setAttribute(SessionAttribute.SESSION_USER,user);
        List<Contract> contractList = null;
        ContractServiceImpl contractService = new ContractServiceImpl();
        System.out.println(request.getParameter(ParameterName.SELECT));
        if (request.getParameter(ParameterName.SELECT).equals(ALL_CONTRACTS)) {
            try {
                contractList = contractService.findAll();
                request.setAttribute(LIST, contractList);
                router = new Router(CONTRACT_MANAGEMENT.getPath());
            } catch (by.epam.finalTask.exception.ServiceException e) {
                e.printStackTrace();
            }
        }
        else if(request.getParameter(ParameterName.SELECT).equals(CONNECTED_CONTRACTS))
        {
            try {
                contractList = contractService.findByStatus(String.valueOf(ContractStatus.CONNECTED));
                request.setAttribute(LIST, contractList);
                router = new Router(CONTRACT_MANAGEMENT.getPath());
            } catch (by.epam.finalTask.exception.ServiceException e) {
                router = new Router(ERROR.getPath());
                e.printStackTrace();
            }
        }

        else if(request.getParameter(ParameterName.SELECT).equals(DISCONNECTED_CONTRACTS))
        {
            try {
                contractList = contractService.findByStatus(String.valueOf(ContractStatus.DISCONNECTED));
                request.setAttribute(LIST, contractList);
                router = new Router(CONTRACT_MANAGEMENT.getPath());
            } catch (by.epam.finalTask.exception.ServiceException e) {
                e.printStackTrace();
            }
        }
        return router;
    }
}
