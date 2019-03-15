package com.chernikin.webapp.web.servlets.action;

import com.chernikin.webapp.domain.User;
import com.chernikin.webapp.database.dao.UserDAO;
import com.chernikin.webapp.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        final User user = userService.getUserByLoginAndPassword(login, password);

        if (isUserAccountActive(user)) {
            HttpSession session = request.getSession();
            session.setAttribute("currentUser", user);
            response.sendRedirect("main-products-page");
            return;
        } else if (!isUserAccountActive(user)) {
            request.setAttribute("activeMessage", "Login unavailable, account blocked");
            request.getRequestDispatcher("login-page.jsp").forward(request, response);
            return;
        }
        request.setAttribute("errorMessage", "Data Not Found, try one more or click on Registration!");
        request.getRequestDispatcher("login-page.jsp").forward(request, response);
    }

    private boolean isUserAccountActive(User user) {
        return user != null && user.getActive();
    }
}
