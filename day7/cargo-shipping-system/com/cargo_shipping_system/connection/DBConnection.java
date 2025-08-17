package com.cargo_shipping_system.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/cargo_shipping_system";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String JDBC_DRIVER_CLASS = "com.mysql.jdbc.Driver";

    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER_CLASS);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            System.err.println("Database connection failed!");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Error Code: " +e.getErrorCode());
            System.err.println("Message: " +e.getMessage());

            e.printStackTrace();
        }

        return conn;
    }

    public static void closeConnection(Connection conn) {
        if (conn != null){
            try {
                conn.close();
                System.out.println("Database connection closed successfully");
            } catch (SQLException e) {
                System.err.println("Error closing database!");
                System.err.println("SQLState: " + e.getSQLState());
                System.err.println("Error Code: " +e.getErrorCode());
                System.err.println("Message: " +e.getMessage());

                e.printStackTrace();
            }
        }
    }
}