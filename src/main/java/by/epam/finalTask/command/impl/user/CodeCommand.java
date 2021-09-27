package by.epam.finalTask.command.impl.user;

import by.epam.finalTask.command.Command;
import by.epam.finalTask.command.CommandException;
import by.epam.finalTask.command.ParameterName;
import by.epam.finalTask.command.SessionAttribute;
import by.epam.finalTask.model.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import static by.epam.finalTask.command.PageName.HOME;

public class CodeCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {

        String page = null;
        String code = request.getParameter(ParameterName.CODE);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
       // потом вернуть это проверка кода if(code.equals( (String) session.getAttribute(SessionAttribute.SESSION_CODE))) {
            session.setAttribute(SessionAttribute.SESSION_USER,user);
            request.setAttribute(ParameterName.LOGIN, user.getLogin());
            request.setAttribute(ParameterName.EMAIL, user.getEmail());
            request.setAttribute(ParameterName.NAME, user.getName());
            request.setAttribute(ParameterName.SURNAME, user.getSurname());
            request.setAttribute(ParameterName.PHONE, user.getPhone());
            session.setAttribute(SessionAttribute.SESSION_USER,user);

            page =HOME.getPath();
      //  }
       // else {
         //   request.setAttribute("fail", "Incorrect code. try again.");
           // page = CODE.getPath();
        //}

        return page;
    }
}
