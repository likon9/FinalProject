package by.epam.task.controller.command.impl.page;

import by.epam.task.controller.command.Command;
import by.epam.task.controller.command.PageName;
import by.epam.task.controller.command.Router;
import by.epam.task.controller.command.SessionAttribute;
import by.epam.task.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class GoToFirstPage implements Command {
    private final static String ENGLISH = "en";
    private final static String RUSSIAN = "ru";
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router;
        HttpSession session = request.getSession();
        if (session.getAttribute(SessionAttribute.LOCALE) == null) {
            session.setAttribute(SessionAttribute.LOCALE, ENGLISH);
        }
        router = new Router(PageName.LOGIN);
        return router;
        }
    }

