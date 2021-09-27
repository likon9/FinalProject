package by.epam.finalTask.command.impl.page;

import by.epam.finalTask.command.Command;
import jakarta.servlet.http.HttpServletRequest;

import static by.epam.finalTask.command.PageName.ERROR;
import static by.epam.finalTask.command.PageName.LOGIN;

public class GoToLoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        try{
            page = LOGIN.getPath();
        }
        catch (NumberFormatException e){
            page = ERROR.getPath();
        }
        return page;
    }
}
