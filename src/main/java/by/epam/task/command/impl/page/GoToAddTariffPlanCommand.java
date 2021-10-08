package by.epam.task.command.impl.page;

import by.epam.task.command.Command;
import by.epam.task.command.Router;
import by.epam.task.command.SessionAttribute;
import by.epam.task.model.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import static by.epam.task.command.PageName.*;

public class GoToAddTariffPlanCommand implements Command {
    @Override
        public Router execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        session.setAttribute(SessionAttribute.SESSION_USER,user);
        Router router;
        router = new Router(ADD_TARIFF_PLAN);
        return router;
    }

}
