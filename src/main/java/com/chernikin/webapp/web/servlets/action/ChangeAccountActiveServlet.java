package com.chernikin.webapp.web.servlets.action;


import com.chernikin.webapp.domain.User;
import com.chernikin.webapp.database.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/changeAccountActive")
public class ChangeAccountActiveServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        User user = userDAO.getUserByLogin(login);
        if (user.getActive().equals(true)) {
            userDAO.changeAccountActive(login, false);
            req.setAttribute("activeMessage", user.getLogin() + " blocked.");
        }
        if (user.getActive().equals(false)) {
            userDAO.changeAccountActive(login, true);
            req.setAttribute("activeMessage", user.getLogin() + " unblocked.");
        }
        req.getRequestDispatcher("generalPage").forward(req, resp);

    }
}
