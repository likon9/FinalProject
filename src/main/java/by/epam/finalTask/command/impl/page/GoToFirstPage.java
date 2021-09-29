package by.epam.finalTask.command.impl.page;

import by.epam.finalTask.command.*;
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
        router = new Router(PageName.LOGIN.getPath());
        System.out.println("0"+session.getAttribute(SessionAttribute.LOCALE));
        return router;
        }
    }

