package by.epam.task.command.impl.page;

import by.epam.task.command.Command;
import by.epam.task.command.Router;
import jakarta.servlet.http.HttpServletRequest;

import static by.epam.task.command.PageName.ERROR;
import static by.epam.task.command.PageName.LOGIN;

public class GoToLoginCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) {
        Router router;
        router = new Router(LOGIN);
        return router;
    }
}
