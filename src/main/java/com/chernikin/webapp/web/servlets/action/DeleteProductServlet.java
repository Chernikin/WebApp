package com.chernikin.webapp.web.servlets.action;

import com.chernikin.webapp.domain.Product;
import com.chernikin.webapp.database.dao.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/deleteById")
public class DeleteProductServlet extends HttpServlet {
    private ProductDAO productDAO = new ProductDAO();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int productId = Integer.parseInt(req.getParameter("productId"));
        Product productById = productDAO.getById(productId);
        productDAO.deleteById(productById.getId());
        req.setAttribute("activeMessage", "Product with id: " + productById.getId() + " delete!");
        req.getRequestDispatcher("generalPage").forward(req, resp);
    }
}
