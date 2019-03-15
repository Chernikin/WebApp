package com.chernikin.webapp.service;

import com.chernikin.webapp.database.DatabaseConnectionManager;
import com.chernikin.webapp.database.dao.UserDAO;
import com.chernikin.webapp.database.dao.UserDetailsDao;
import com.chernikin.webapp.domain.User;
import com.chernikin.webapp.domain.UserDetails;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserService {

    private UserDAO userDAO = new UserDAO();
    private UserDetailsDao userDetailsDao = new UserDetailsDao();

    public int createUser(User user) {
        final UserDetails userDetails = user.getUserDetails();
        Connection connection = null;
        try {
            connection = DatabaseConnectionManager.getConnection();
            final int userDetailsID = userDetailsDao.create(connection, userDetails);
            userDetails.setId(userDetailsID);
            final int userId = userDAO.create(connection, user);
            connection.commit();
            return userId;
        } catch (SQLException e) {
            DatabaseConnectionManager.rollback(connection);
        } finally {
            DatabaseConnectionManager.closeConnection(connection);
        }
        return -1;
    }

    public User getUserById(int id) {
        Connection connection = null;
        try {
            connection = DatabaseConnectionManager.getConnection();
            return userDAO.getById(connection, id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnectionManager.closeConnection(connection);
        }
        return null;
    }

    public List<User> getAllUsersByRole(String... roles) {
        Connection connection = null;
        try {
            connection = DatabaseConnectionManager.getConnection();
            return userDAO.getUsersByRole(connection, roles);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnectionManager.closeConnection(connection);
        }
        return null;
    }

    public User getUserByLoginAndPassword(String login, String password) {
        Connection connection = null;
        try {
            connection = DatabaseConnectionManager.getConnection();
            return userDAO.getUser(connection, login, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnectionManager.closeConnection(connection);
        }
        return null;
    }
}
