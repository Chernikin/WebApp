package com.chernikin.webapp.web.servlets;

import com.chernikin.webapp.domain.Product;
import com.chernikin.webapp.database.dao.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/link-to-update-product")
public class LinkToUpdateProductServlet extends HttpServlet {
    private ProductDAO productDAO = new ProductDAO();


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int productId = Integer.parseInt(req.getParameter("productId"));
        Product productById = productDAO.getById(productId);
        req.setAttribute("product", productById);

        req.getRequestDispatcher("update-product-page.jsp").forward(req, resp);
    }
}
