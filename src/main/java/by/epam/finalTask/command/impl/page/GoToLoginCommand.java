package by.epam.finalTask.command.impl.page;

import by.epam.finalTask.command.Command;
import by.epam.finalTask.command.Router;
import jakarta.servlet.http.HttpServletRequest;

import static by.epam.finalTask.command.PageName.ERROR;
import static by.epam.finalTask.command.PageName.LOGIN;

public class GoToLoginCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) {
        Router router;
        try{
            router = new Router(LOGIN.getPath());
        }
        catch (NumberFormatException e){
            router = new Router(ERROR.getPath());
        }
        return router;
    }
}
