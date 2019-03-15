package com.chernikin.webapp.web.servlets;

import com.chernikin.webapp.domain.Product;
import com.chernikin.webapp.database.ProductCriteria;
import com.chernikin.webapp.domain.User;
import com.chernikin.webapp.database.dao.ProductDAO;
import com.chernikin.webapp.database.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/generalPage")
public class DisplayTablesOnPageServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();
    private ProductDAO productDAO = new ProductDAO();
    private ProductCriteria productCriteria = new ProductCriteria();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User currentUser = (User) session.getAttribute("user");
        List<Product> allProducts = productDAO.getProductByCriteria(productCriteria);
        req.setAttribute("productList", allProducts);
        List<User> users = userDAO.getUsersByRole("user", "moderator");
        req.setAttribute("list1", users);
        List<User> allUser = userDAO.getUsersByRole("user");
        req.setAttribute("list2", allUser);
//        req.setAttribute("message", currentUser.getFirstName() + " " + currentUser.getLastName());
        String currentUserRole = currentUser.getRole();
        if (currentUserRole.equals("admin")) {
            req.getRequestDispatcher("welcome-admin.jsp").forward(req, resp);
        } if (currentUserRole.equals("moderator")) {
            req.getRequestDispatcher("welcome-moderator.jsp").forward(req, resp);
        } if(currentUserRole.equals("user")) {
            req.getRequestDispatcher("welcome-user.jsp").forward(req, resp);
        }
    }
}
