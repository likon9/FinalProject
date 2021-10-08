package by.epam.task.command.impl.user;

import by.epam.task.command.Command;
import by.epam.task.exception.CommandException;
import by.epam.task.command.Router;
import by.epam.task.command.SessionAttribute;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import static by.epam.task.command.PageName.LOGIN;

public class ExitUserCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router;
        HttpSession session = request.getSession();
        session.setAttribute(SessionAttribute.SESSION_USER,null);
        router = new Router(LOGIN);
        return router;
    }
}
