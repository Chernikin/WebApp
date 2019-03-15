package com.chernikin.webapp.web.servlets.action;

import com.chernikin.webapp.domain.Product;
import com.chernikin.webapp.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(urlPatterns = "/addToCart")
public class AddToCartServlet extends HttpServlet {

    private ProductService productService = new ProductService();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int productId = Integer.parseInt(req.getParameter("productId"));
        Product productById = productService.getProductById(productId);

        HttpSession session = req.getSession();

        final List<Product> userCart = getUserCart(session);
        userCart.add(productById);
        req.getRequestDispatcher("generalPage").forward(req, resp);
    }

    private List<Product> getUserCart(HttpSession session) {
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart != null) {
            return cart;
        } else {
            final List<Product> newCart = new ArrayList<>();
            session.setAttribute("cart", newCart);
            return newCart;
        }
    }
}
