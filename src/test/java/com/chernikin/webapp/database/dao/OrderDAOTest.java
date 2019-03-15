package com.chernikin.webapp.database.dao;

import com.chernikin.webapp.domain.Order;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderDAOTest {

    @Ignore
    @Test
    public void returnOrderIdIfOrderSuccessfullySavedInDatabase() {
        OrderDAO orderDAO = new OrderDAO();
        Order order = new Order();

        order.setIdProduct(6);
        order.setCity("Las Vegas");
        order.setPostNumber(64);
        order.setCardNumber(5555222233331111L);
        order.setMonth(9);
        order.setYear(25);
        order.setCvv(685);
        int i = orderDAO.create(order);

        assertTrue(i > -1);
    }
}
