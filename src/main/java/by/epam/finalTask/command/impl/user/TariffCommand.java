package by.epam.finalTask.command.impl.user;


import by.epam.finalTask.command.Command;
import by.epam.finalTask.command.CommandException;
import by.epam.finalTask.command.SessionAttribute;
import by.epam.finalTask.exception.DaoException;
import by.epam.finalTask.model.dao.TariffPlanDao;
import by.epam.finalTask.model.entity.TariffPlan;
import by.epam.finalTask.model.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;

import static by.epam.finalTask.command.PageName.ERROR;
import static by.epam.finalTask.command.PageName.TARIFF;

public class TariffCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page = null;

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        session.setAttribute(SessionAttribute.SESSION_USER,user);
        try {
            TariffPlanDao tariffPlanDao = new TariffPlanDao();
            List<TariffPlan> tariffPlanList = tariffPlanDao.findAll();
            request.setAttribute("list", tariffPlanList);
            page = TARIFF.getPath();
        }
        catch (DaoException e) {
            page = ERROR.getPath();
            e.printStackTrace();
     }
        return page;
    }
}
