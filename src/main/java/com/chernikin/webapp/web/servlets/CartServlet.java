package com.chernikin.webapp.web.servlets;

import com.chernikin.webapp.domain.Order;
import com.chernikin.webapp.domain.Product;
import com.chernikin.webapp.RandomId;
import com.chernikin.webapp.database.dao.OrderDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/cart")
public class CartServlet extends HttpServlet {

    private OrderDAO orderDAO = new OrderDAO();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fName = req.getParameter("fName");
        String lName = req.getParameter("lName");
        String city = req.getParameter("city");
        int postNumber = Integer.parseInt(req.getParameter("postNumber"));
        long cardNumber = Long.parseLong(req.getParameter("cardNumber"));
        int month = Integer.parseInt(req.getParameter("month"));
        int year = Integer.parseInt(req.getParameter("year"));
        int cvv = Integer.parseInt(req.getParameter("cvv"));

        HttpSession session = req.getSession();
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        for (Product orders : cart) {
            Order order = createOrder(fName, lName, city, postNumber, cardNumber, month, year, cvv, orders);
            orderDAO.create(order);
        }
        req.getRequestDispatcher("order-accepted.jsp").forward(req, resp);
    }

    private Order createOrder(String fName, String lName, String city, int postNumber, long cardNumber,
                              int month, int year, int cvv, Product orders) {
        Order order = new Order();
        order.setOrderId(RandomId.getRandomId());
        order.setIdProduct(orders.getId());
        order.setfName(fName);
        order.setlName(lName);
        order.setCity(city);
        order.setPostNumber(postNumber);
        order.setCardNumber(cardNumber);
        order.setMonth(month);
        order.setYear(year);
        order.setCvv(cvv);
        return order;
    }
}
