package com.chernikin.webapp.web.servlets.page;

import com.chernikin.webapp.domain.Product;
import com.chernikin.webapp.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/manage-products-page")
public class ManageProductsPageServlet extends HttpServlet {

    private ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final List<Product> allProducts = productService.getAllProducts();
        req.setAttribute("allProducts", allProducts);
        req.getRequestDispatcher("manage-products-page.jsp").forward(req, resp);
    }
}
