package com.chernikin.webapp;


import com.chernikin.webapp.domain.Order;

public class RandomId {
    private final static int min = 1;
    private final static int max = 999;

    public static int getRandomId() {
        Order order = new Order();
        int orderId = order.getOrderId();
        int random = (int) (Math.random() * max) + min;
        if  (orderId != random){
            return random;
        }else {
            return random + min;
        }
    }
}
