package by.epam.finalTask.command.impl.admin.userManagement;

import by.epam.finalTask.command.*;
import by.epam.finalTask.model.entity.User;
import by.epam.finalTask.model.service.impl.UserServiceImpl;
import com.google.protobuf.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.epam.finalTask.model.dao.ColumnName.USER_ID;
import static by.epam.finalTask.model.dao.ColumnName.USER_STATUS;

public class BlockUserCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.SESSION_USER);
        session.setAttribute(SessionAttribute.SESSION_USER,user);
        UserServiceImpl userService = new UserServiceImpl();
        Map<String, String> updateUser = new HashMap<>();
        Long userId = Long.valueOf(request.getParameter(USER_ID));
        updateUser.put(USER_STATUS, "2");
        try {
            if(userService.updateStatus(updateUser, userId)) {
                request.setAttribute("answer","user " + userId + " has been blocked");
            }
            else {
                request.setAttribute("answer","user " + userId + " hasn't been blocked");
            }
            router = new Router(PageName.USER_LIST.getPath());
        } catch (ServiceException e) {
            e.printStackTrace();
            router = new Router(PageName.ERROR.getPath());
        }
        List<User> userList = null;
        try {
            userList = userService.findAll();
            request.setAttribute("list", userList);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return  router;
    }
}
