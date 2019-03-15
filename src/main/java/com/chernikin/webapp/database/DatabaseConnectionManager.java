package com.chernikin.webapp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionManager {

    private static final String MYSQL_DATABASE_URL = "jdbc:mysql://127.0.0.1:3307/MYDB";
    private static final String MYSQL_DATABASE_USERNAME = "root";
    private static final String MYSQL_DATABASE_PASSWORD = "Root";

    private static final String POSTGRES_DATABASE_URL = "jdbc:postgresql://127.0.0.1:3306/postgres";
    private static final String POSTGRES_DATABASE_USERNAME = "postgres";
    private static final String POSTGRES_DATABASE_PASSWORD = "password123";

    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(MYSQL_DATABASE_URL, MYSQL_DATABASE_USERNAME, MYSQL_DATABASE_PASSWORD);
        } catch (SQLException e) {
            return DriverManager.getConnection(POSTGRES_DATABASE_URL, POSTGRES_DATABASE_USERNAME, POSTGRES_DATABASE_PASSWORD);
        }
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void rollback(Connection connection) {
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void commit(Connection connection) {
        if (connection != null) {
            try {
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
