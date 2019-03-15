package com.chernikin.webapp.web.servlets.action;

import com.chernikin.webapp.domain.User;
import com.chernikin.webapp.database.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/changeAccountRole")
public class ChangeAccountRoleServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        User user = userDAO.getUserByLogin(login);
        if (user.getRole().equals("user")) {
            userDAO.changeAccountRole(login, "moderator");
            req.setAttribute("activeMessage", user.getLogin() + " moderator now!");
        }
        if (user.getRole().equals("moderator")) {
            userDAO.changeAccountRole(login, "user");
            req.setAttribute("activeMessage", user.getLogin() + " user now!");
        }
        req.getRequestDispatcher("manage-users-page").forward(req, resp);
    }
}
