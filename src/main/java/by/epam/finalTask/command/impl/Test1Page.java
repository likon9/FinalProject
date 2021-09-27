package by.epam.finalTask.command.impl;

import by.epam.finalTask.command.Command;
import by.epam.finalTask.command.CommandException;
import by.epam.finalTask.command.SessionAttribute;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import static by.epam.finalTask.command.PageName.ERROR;
import static by.epam.finalTask.command.PageName.LOGIN;
import static by.epam.finalTask.command.SessionAttribute.SESSION_USER;

public class Test1Page implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {

        String page;
        HttpSession session = request.getSession();
        Object user = session.getAttribute(SESSION_USER);
        session.setAttribute(SessionAttribute.SESSION_USER, user);

        try{
            page = LOGIN.getPath();
        }
        catch (NumberFormatException e){
            page = ERROR.getPath();
        }
        return page;
    }

}

