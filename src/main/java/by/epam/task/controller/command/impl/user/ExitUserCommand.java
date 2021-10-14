package by.epam.task.controller.command.impl.user;

import by.epam.task.controller.command.Command;
import by.epam.task.exception.CommandException;
import by.epam.task.controller.command.Router;
import by.epam.task.controller.command.SessionAttribute;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.epam.task.controller.command.PageName.LOGIN;

public class ExitUserCommand implements Command {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router;
        HttpSession session = request.getSession();
        session.setAttribute(SessionAttribute.SESSION_USER,null);
        logger.info("Successfully navigated to the home page");
        router = new Router(LOGIN);
        return router;
    }
}
