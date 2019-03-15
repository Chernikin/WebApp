package com.chernikin.webapp.database.dao;

import com.chernikin.webapp.database.DatabaseConnectionManager;
import com.chernikin.webapp.domain.User;
import com.chernikin.webapp.domain.UserDetails;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserDAO implements GenericDao<User> {

    @Override
    public int create(Connection connection, User user) {
        String sql = "INSERT INTO users(login, password, user_details_id) VALUES(?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, user.getUserDetails().getId());
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
    public User getById(Connection connection, int id) {
        throw new UnsupportedOperationException("This operations is not implemented yet");
    }

    @Override
    public User update(Connection connection, User object) {
        throw new UnsupportedOperationException("This operations is not implemented yet");
    }

    @Override
    public void deleteById(Connection connection, int id) {
        throw new UnsupportedOperationException("This operations is not implemented yet");
    }

    public User getUser(Connection connection, String login, String password) {
        String sql = "SELECT * FROM users join user_details on users.user_details_id = user_details.id WHERE login = ? AND password = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return extractUserFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> getUsersByRole(Connection connection, String... roles) {
        String sql = "select * from users join user_details on users.user_details_id = user_details.id where role in (";
        List<String> role = new ArrayList<>();
        for (String rol : roles) {
            role.add("'" + rol + "'");
        }
        String rolesSql = String.join(",", role);
        sql += rolesSql + ")";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(extractUserFromResultSet(resultSet));
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public User getUserByLogin(Connection connection, String login) {
        String sql = "SELECT * FROM users  join user_details on users.user_details_id = user_details.id WHERE login = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return extractUserFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User changeAccountActive(Connection connection, String login, boolean active) {
        String sql = "UPDATE users SET active = ? WHERE login = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, active);
            preparedStatement.setString(2, login);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User changeAccountRole(Connection connection, String login, String role) {
        String sql = "UPDATE users SET role = ? WHERE login = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, role);
            preparedStatement.setString(2, login);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private User extractUserFromResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setRole(resultSet.getString("role"));
        user.setLogin(resultSet.getString("login"));
        user.setPassword(resultSet.getString("password"));
        user.setActive(resultSet.getBoolean("active"));

        final UserDetails userDetails = new UserDetails();

        userDetails.setId(resultSet.getInt("id"));
        userDetails.setFirstName(resultSet.getString("first_name"));
        userDetails.setLastName(resultSet.getString("last_name"));

        user.setUserDetails(userDetails);
        return user;
    }

}
