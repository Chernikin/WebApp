package com.chernikin.webapp.web.servlets.page;

import com.chernikin.webapp.domain.User;
import com.chernikin.webapp.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/manage-users-page")
public class ManageUsersPageServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final List<User> users = getUsersByActualRole(req);
        req.setAttribute("allUsers", users);
        req.getRequestDispatcher("manage-users-page.jsp").forward(req, resp);
    }

    private List<User> getUsersByActualRole(HttpServletRequest request) {
        final HttpSession session = request.getSession();
        final User user = (User) session.getAttribute("currentUser");
        if (user.getRole().equals("admin")) {
            userService.getAllUsersByRole("user", "moderator");
        }
        return userService.getAllUsersByRole("user");
    }
}
