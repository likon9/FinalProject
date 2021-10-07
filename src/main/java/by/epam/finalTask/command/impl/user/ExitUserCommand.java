package by.epam.finalTask.command.impl.user;

import by.epam.finalTask.command.Command;
import by.epam.finalTask.command.CommandException;
import by.epam.finalTask.command.Router;
import by.epam.finalTask.command.SessionAttribute;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import static by.epam.finalTask.command.PageName.LOGIN;

public class ExitUserCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router;

        HttpSession session = request.getSession();

        session.setAttribute(SessionAttribute.SESSION_USER,null);
        router = new Router(LOGIN.getPath());
        return router;
    }
}
