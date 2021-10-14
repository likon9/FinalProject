package by.epam.task.controller.command.impl.page;

import by.epam.task.controller.command.Command;
import by.epam.task.controller.command.Router;
import by.epam.task.controller.command.SessionAttribute;
import by.epam.task.model.entity.User;
import by.epam.task.model.entity.UserRole;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import static by.epam.task.controller.command.PageName.*;

public class GoToAddTariffPlanCommand implements Command {
    @Override
        public Router execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        if(user == null || user.getUserStatus().equals(UserRole.USER))
        {
            return new Router(ERROR_404);
        }
        session.setAttribute(SessionAttribute.SESSION_USER,user);
        Router router;
        router = new Router(ADD_TARIFF_PLAN);
        return router;
    }

}
