package com.chernikin.webapp.database.dao;

import com.chernikin.webapp.domain.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDAO implements GenericDao<Order> {

    @Override
    public int create(Connection connection, Order order) {
        String sql = "INSERT INTO orders(orderId, idProduct, fName, lName, city, postNumber, cardNumber, month, year, cvv) VALUES (?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, order.getOrderId());
            preparedStatement.setInt(2, order.getIdProduct());
            preparedStatement.setString(3, order.getfName());
            preparedStatement.setString(4, order.getlName());
            preparedStatement.setString(5, order.getCity());
            preparedStatement.setInt(6, order.getPostNumber());
            preparedStatement.setLong(7, order.getCardNumber());
            preparedStatement.setInt(8, order.getMonth());
            preparedStatement.setInt(9, order.getYear());
            preparedStatement.setInt(10, order.getCvv());
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Order getById(Connection connection, int id) {
        throw new UnsupportedOperationException("This operations is not implemented yet");
    }

    @Override
    public Order update(Connection connection, Order order) {
        throw new UnsupportedOperationException("This operations is not implemented yet");
    }

    @Override
    public void deleteById(Connection connection, int id) {
        throw new UnsupportedOperationException("This operations is not implemented yet");
    }

}
