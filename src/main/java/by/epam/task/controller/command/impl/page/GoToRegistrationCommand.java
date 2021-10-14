package by.epam.task.controller.command.impl.page;

import by.epam.task.controller.command.Command;
import by.epam.task.controller.command.Router;
import jakarta.servlet.http.HttpServletRequest;

import static by.epam.task.controller.command.PageName.REGISTRATION;

public class GoToRegistrationCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) {
        Router router;
        router = new Router(REGISTRATION);
        return router;
    }
}
