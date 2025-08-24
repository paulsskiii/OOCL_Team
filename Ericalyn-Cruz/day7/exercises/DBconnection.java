package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnection{
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/cargo_shipping_system";
    public static final String USER = "root";
    public static final String PASSWORD = "";
    
    public static Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            System.out.println("Database connection established successfully!");
        } catch (SQLException   e){
            System.err.println("Database connection failed");
            System.err.println("SQL State:" + e.getSQLState());
            System.err.println("Error Code:" + e.getErrorCode());
            System.err.println("Message:" + e.getMessage());

            e.printStackTrace();  
        }
        
        return connection;
    }

    public static void closeConnection (Connection connection) {
        
        if (connection != null){
            try {
            connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            System.out.println("Database connection closed successfully!");
            } catch (SQLException   e){
                System.err.println("Error in closing database connection!");
                System.err.println("SQL State:" + e.getSQLState());
                System.err.println("Error Code:" + e.getErrorCode());
                System.err.println("Message:" + e.getMessage());

                e.printStackTrace();  
            }
        }
    }

    
    public static void main(String[] args){
        System.out.println("Attempting to get database connection...");
        Connection conn = DBconnection.getConnection();
        if (conn != null){
            System.out.println("Connection test successful");
            
            String sql = "SELECT p.*\n" + //
                                "FROM Package p\n" + //
                                "JOIN Transactions t ON p.package_id = t.package_id\n" + //
                                "JOIN Customer c ON c.customer_id = t.sender_id\n" + //
                                "ORDER BY package_id;";
            
            try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
               
            while (rs.next()){
                int packageID = rs.getInt("package_id");
                String packageType = rs.getString("package_type");
                double weight = rs.getFloat("weight");
                String contentsDescription = rs.getString("contents_description");

                System.out.printf("Product ID: %d, package Type %s, weight: $%.2f, Content Description: %s%n", packageID, packageType, weight, contentsDescription);
        
            }    
            
            }catch (SQLException e){
                e.printStackTrace();
            }

            DBconnection.closeConnection(conn);
        } else {
            System.out.println("Connection test failed. Please check your database server and credentials.");
        }
    }

}