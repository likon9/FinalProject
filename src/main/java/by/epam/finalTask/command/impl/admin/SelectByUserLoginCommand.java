package by.epam.finalTask.command.impl.admin;

import by.epam.finalTask.command.Command;
import by.epam.finalTask.command.CommandException;
import by.epam.finalTask.command.SessionAttribute;
import by.epam.finalTask.model.entity.User;
import by.epam.finalTask.model.service.impl.UserServiceImpl;
import com.google.protobuf.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static by.epam.finalTask.command.PageName.ERROR;
import static by.epam.finalTask.command.PageName.USER_LIST;

public class SelectByUserLoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page = null;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        session.setAttribute(SessionAttribute.SESSION_USER, user);
        String login = request.getParameter("login");
        UserServiceImpl userService = new UserServiceImpl();
        Optional<User> userOptional = null;
        try {
            userOptional = userService.findByLogin(login);
            List<User> user1= userOptional.isPresent()
                    ? Collections.singletonList(userOptional.get())
                    : Collections.emptyList();;
            request.setAttribute("list", user1);
            page = USER_LIST.getPath();
        } catch (ServiceException e) {
            e.printStackTrace();
            page = ERROR.getPath();
        }
        return page;
    }
}