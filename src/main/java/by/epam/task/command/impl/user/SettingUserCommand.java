package by.epam.task.command.impl.user;

import by.epam.task.command.*;
import by.epam.task.exception.CommandException;
import by.epam.task.model.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import static by.epam.task.command.PageName.SETTING_USER;

public class SettingUserCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        request.setAttribute(ParameterName.LOGIN, user.getLogin());
        request.setAttribute(ParameterName.EMAIL, user.getEmail());
        request.setAttribute(ParameterName.NAME, user.getName());
        request.setAttribute(ParameterName.SURNAME, user.getSurname());
        request.setAttribute(ParameterName.PHONE, user.getPhone());
        session.setAttribute(SessionAttribute.SESSION_USER,user);
        router = new Router(SETTING_USER);
        return router;
    }
}

