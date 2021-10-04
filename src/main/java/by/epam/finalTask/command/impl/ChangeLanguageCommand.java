package by.epam.finalTask.command.impl;

import by.epam.finalTask.command.Command;
import by.epam.finalTask.command.PageName;
import by.epam.finalTask.command.Router;
import by.epam.finalTask.command.SessionAttribute;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class ChangeLanguageCommand implements Command {

    private static final String ENGLISH = "en";
    private static final String RUSSIAN = "ru";

    @Override
    public Router execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String language = session.getAttribute(SessionAttribute.LOCALE).toString();
        if (language.equals(ENGLISH)) {
            session.setAttribute(SessionAttribute.LOCALE, RUSSIAN);
        } else {
            session.setAttribute(SessionAttribute.LOCALE, ENGLISH);
        }
        Router router = new Router(PageName.LOGIN.getPath());
        return router;
    }
}
