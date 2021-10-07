package by.epam.finalTask.command.impl.page;

import by.epam.finalTask.command.Command;
import by.epam.finalTask.command.CommandException;
import by.epam.finalTask.command.Router;
import by.epam.finalTask.command.SessionAttribute;
import by.epam.finalTask.model.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import static by.epam.finalTask.command.PageName.*;

public class GoToAddTariffPlanCommand implements Command {
    @Override
        public Router execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        session.setAttribute(SessionAttribute.SESSION_USER,user);
        Router router;
        try{
            router = new Router(ADD_TARIFF_PLAN.getPath());
        }
        catch (NumberFormatException e){
            router = new Router(ERROR.getPath());
        }
        return router;
    }

}
