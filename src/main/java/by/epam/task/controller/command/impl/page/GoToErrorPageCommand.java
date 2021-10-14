package by.epam.task.controller.command.impl.page;

import by.epam.task.controller.command.Command;
import by.epam.task.controller.command.PageName;
import by.epam.task.controller.command.Router;
import by.epam.task.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GoToErrorPageCommand implements Command {
	private static final Logger logger = LogManager.getLogger();


	@Override
	public Router execute(HttpServletRequest request) throws CommandException {
		logger.log(Level.INFO, "method execute()");
		Router router;
		logger.log(Level.INFO, "redirected to error 404 page");
		router = new Router(PageName.ERROR_404);
		router.setRedirect();
		return router;
	}

}
