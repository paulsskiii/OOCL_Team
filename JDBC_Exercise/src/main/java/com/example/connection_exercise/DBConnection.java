package com.example.connection_exercise;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class DBConnection {
        private static final String JDBC_URL = "jdbc:mysql://localhost:3306/cargo_shipping_system";
        private static final String USER = "root";
        private static final String PASSWORD = "admin";

        public static Connection getConnection() {
            // Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = null;

            try {
                connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
                System.out.println("Database connections established successfully!");
            } catch (SQLException e) {
                System.out.println("Database connection failed");
            }

            return connection;
        }

        public static void closeConnection(Connection connection) {
            if(connection != null) {
                try {
                    connection.close();
                    System.out.println("DB Connection closed!");
                } catch (SQLException e) {
                    System.err.println("Error closing database connection!");
                    e.printStackTrace();
                }   
            }
        }

        public static void main (String[] args) {
            System.out.println("Attempting to get a DB connection...");
            Connection conn = getConnection();

            try(Statement stmt = conn.createStatement()) {
                System.out.println("Connection test successful!");
                ResultSet rs = stmt.executeQuery("SELECT * FROM CUSTOMERS");

                while(rs.next()) {
                    System.out.println(rs.getInt("customer_id"));
                }
                    closeConnection(conn);
            } catch (SQLException e) {
                System.out.println("Connection test failed!");
            }
        }
}