package com.chernikin.webapp.database.dao;

import com.chernikin.webapp.domain.UserDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDetailsDao implements GenericDao<UserDetails> {

    @Override
    public int create(Connection connection, UserDetails userDetails) {
        String sql = "INSERT INTO user_details(first_name, last_name) VALUES(?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, userDetails.getFirstName());
            preparedStatement.setString(2, userDetails.getLastName());
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
    public UserDetails getById(Connection connection, int id) {
        String sql = "SELECT * FROM user_details WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                final UserDetails userDetails = new UserDetails();
                userDetails.setId(resultSet.getInt("id"));
                userDetails.setFirstName(resultSet.getString("first_name"));
                userDetails.setLastName(resultSet.getString("last_name"));
                return userDetails;
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UserDetails update(Connection connection, UserDetails object) {
        return null;
    }

    @Override
    public void deleteById(Connection connection, int id) {

    }
}
