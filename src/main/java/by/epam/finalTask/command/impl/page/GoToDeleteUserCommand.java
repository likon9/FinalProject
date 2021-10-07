package by.epam.finalTask.command.impl.page;

import by.epam.finalTask.command.*;
import by.epam.finalTask.model.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import static by.epam.finalTask.command.PageName.*;

public class GoToDeleteUserCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        session.setAttribute(SessionAttribute.SESSION_USER,user);

        try{
            request.setAttribute(ParameterName.NAME, user.getName());
            router = new Router(DELETE_USER.getPath());
        }
        catch (NumberFormatException e){
            router = new Router(ERROR.getPath());
        }
        return router;
    }
}
