package com.chernikin.webapp.web.servlets.action;

import com.chernikin.webapp.domain.User;
import com.chernikin.webapp.database.dao.UserDAO;
import com.chernikin.webapp.domain.UserDetails;
import com.chernikin.webapp.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/registration-action")
public class RegistrationActionServlet extends HttpServlet {

    private UserService userService = new UserService();
    private UserDAO userDAO = new UserDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setLogin(request.getParameter("login"));
        user.setPassword(request.getParameter("password"));

        final UserDetails userDetails = new UserDetails();
        userDetails.setFirstName(request.getParameter("firstName"));
        userDetails.setLastName(request.getParameter("lastName"));
        user.setUserDetails(userDetails);

        userService.createUser(user);
        int id = userDAO.create(user);
        if (id != -1) {
            request.setAttribute("successMessage", "Registration is done, please login to continue!");
            request.getRequestDispatcher("login-page.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Registration failed!");
            request.getRequestDispatcher("login-page.jsp").forward(request, response);
        }
    }
}
