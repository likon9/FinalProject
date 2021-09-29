package by.epam.finalTask.command.impl.page;

import by.epam.finalTask.command.Command;
import by.epam.finalTask.command.CommandException;
import by.epam.finalTask.command.Router;
import by.epam.finalTask.command.SessionAttribute;
import jakarta.servlet.http.HttpServletRequest;

import static by.epam.finalTask.command.PageName.*;

public class GoToAddTariffPlanCommand implements Command {
    @Override
        public Router execute(HttpServletRequest request) {
        Router router;
        try{
            router = new Router(ADD_TARIFF_PLAN.getPath());
        }
        catch (NumberFormatException e){
            router = new Router(ERROR.getPath());
        }
        return router;
    }

}
