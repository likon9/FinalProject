package by.epam.task.command.impl.page;

import by.epam.task.command.*;
import by.epam.task.exception.CommandException;
import by.epam.task.model.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import static by.epam.task.command.PageName.*;

public class GoToDeleteUserCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        session.setAttribute(SessionAttribute.SESSION_USER,user);
        request.setAttribute(ParameterName.NAME, user.getName());
        router = new Router(DELETE_USER);
        return router;
    }
}
