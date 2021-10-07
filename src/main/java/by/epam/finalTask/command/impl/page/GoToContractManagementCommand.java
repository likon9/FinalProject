package by.epam.finalTask.command.impl.page;

import by.epam.finalTask.command.*;
import by.epam.finalTask.model.entity.Contract;
import by.epam.finalTask.model.entity.User;
import by.epam.finalTask.model.service.ContractService;
import by.epam.finalTask.model.service.impl.ContractServiceImpl;
import by.epam.finalTask.model.service.impl.UserServiceImpl;
import com.google.protobuf.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;

import static by.epam.finalTask.command.PageName.*;

public class GoToContractManagementCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        session.setAttribute(SessionAttribute.SESSION_USER,user);
        ContractServiceImpl contractService = new ContractServiceImpl();
        List<Contract> contractList = null;
        try {
            contractList = contractService.findAll();
            request.setAttribute(ParameterName.LIST,contractList);
            router = new Router(CONTRACT_MANAGEMENT.getPath());
        } catch (by.epam.finalTask.exception.ServiceException e) {
            e.printStackTrace();
            router = new Router(ERROR.getPath());

        }
        return router;
    }
}
