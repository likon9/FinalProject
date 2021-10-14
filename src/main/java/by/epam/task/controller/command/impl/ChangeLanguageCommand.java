package by.epam.task.controller.command.impl;

import by.epam.task.controller.command.Command;
import by.epam.task.controller.command.PageName;
import by.epam.task.controller.command.Router;
import by.epam.task.controller.command.SessionAttribute;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChangeLanguageCommand implements Command {

    private static final Logger logger = LogManager.getLogger();

    private static final String ENGLISH = "en";
    private static final String RUSSIAN = "ru";

    @Override
    public Router execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String language = session.getAttribute(SessionAttribute.LOCALE).toString();
        if (language.equals(ENGLISH)) {
            session.setAttribute(SessionAttribute.LOCALE, RUSSIAN);
            logger.info("Language changed to Russian.");
        } else {
            session.setAttribute(SessionAttribute.LOCALE, ENGLISH);
            logger.info("Language changed to English.");
        }
        Router router = new Router(PageName.LOGIN);
        return router;
    }
}
