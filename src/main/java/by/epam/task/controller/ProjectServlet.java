package by.epam.task.controller;

import by.epam.task.controller.command.*;
import by.epam.task.exception.CommandException;
import by.epam.task.model.pool.ConnectionPool;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import static by.epam.task.controller.command.PageName.ERROR_404;
import static by.epam.task.controller.command.ParameterName.COMMAND;

/**
 * The type Project servlet.Controller servlet.
 */
@WebServlet("/controller")
public class ProjectServlet extends HttpServlet {
        private static final Logger logger = LogManager.getLogger();
        private final CommandProvider provider = CommandProvider.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            processRequest(request, response);
        }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            processRequest(request, response);
        }

        private void processRequest(HttpServletRequest request, HttpServletResponse response)
                throws IOException, ServletException {
            logger.log(Level.INFO, "method processRequest()");
            String commandName = request.getParameter(COMMAND);
            Command command = provider.getCommand(commandName);
            Router router = null;
            try {
                router = command.execute(request);
                switch (router.getType()) {
                    case REDIRECT -> response.sendRedirect(router.getPagePath());
                    case FORWARD -> request.getRequestDispatcher(router.getPagePath()).forward(request, response);
                    default -> {
                        logger.log(Level.ERROR, "unknown router type: {}", router.getType());
                        response.sendRedirect(ERROR_404);
                    }
                }
            } catch (CommandException e) {
                logger.log(Level.ERROR, "unknown router type: {}", router.getType());
                response.sendRedirect(ERROR_404);
            }
        }

}