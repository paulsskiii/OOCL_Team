package com.precious.medialibrary.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
    
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/shipping";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    public static Connection getConnection() {

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            System.out.println("Database connection establish successfully.");
        } catch (SQLException e) {
            System.err.println("Database connection failed.");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("Message: " + e.getMessage());
        }
        return connection;
    }

}