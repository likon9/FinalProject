package by.epam.task.controller;

import by.epam.task.command.*;
import by.epam.task.exception.CommandException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import static by.epam.task.command.PageName.ERROR;

@WebServlet(name = "ProjectServlet", value = "/controller")
public class ProjectServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request,response);
    }


    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String commandStr = request.getParameter("command");
        Command command = CommandType.takeCommand(commandStr);
        System.out.println(commandStr);
        Router router = null;
        try {
            router = command.execute(request);
        } catch (CommandException e) {
            e.printStackTrace();
            router = new Router(ERROR);
        }
        switch (router.getType()) {
            case REDIRECT:
                response.sendRedirect(router.getPage());
                break;
            case FORWARD:
                RequestDispatcher requestDispatcher = request.getRequestDispatcher(router.getPage());
                requestDispatcher.forward(request, response);
                break;
            default:
                logger.error("Error in router type: ", router.getType());
                response.sendRedirect(ERROR);
        }
    }

}