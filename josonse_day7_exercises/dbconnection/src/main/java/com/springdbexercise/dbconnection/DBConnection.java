package com.springdbexercise.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/cargo_shipping_system";
    // root@localhost:3306
    private static final String USER = "root";

    private static final String PASSWORD = "admin";


    public static Connection getConnection(){
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            System.out.println("Database connection established successfully!");
        } catch (SQLException e) {
            // TODO: handle exception
            System.err.println("Database connection failed!");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("Message: " + e.getMessage());

        }
        return connection;
    }

    public static void closeConnection (Connection connection){
        if (connection != null){
            try {
                connection.close();
                System.out.println("Database connection closed successfully");
            } catch (SQLException e) {
                // TODO: handle exception
                System.err.println("Error closing database connection!");
                System.err.println("SQLState: " + e.getSQLState());
                System.err.println("Error Code: " + e.getErrorCode());
                System.err.println("Message: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static void main (String[] args){
        System.out.println("Attempting to get a database connection...");
        Connection conn = DBConnection.getConnection();
        if(conn != null){
            System.out.println("Connection test successful!");
            
            String sql = "SELECT * FROM package";

            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)){                
                    
                while(rs.next()){
                    int package_id = rs.getInt("package_id");
                    String pickup_date = rs.getString("pickup_date");
                    String delivery_date = rs.getString("delivery_date");
                    int package_type_id = rs.getInt("package_type_id");
                    float weight = rs.getFloat("weight");
                    String contents_description = rs.getString("contents_description");
                    int sender_id = rs.getInt("sender_id");
                    int recipient_id = rs.getInt("recipient_id");
                    String created_at = rs.getString("created_at");

                    System.out.printf("packageId: %s | pickup_date: %s | delivery_date: %s | package_type_id: %s | weight: %s | content: %s", 
                    package_id, pickup_date, delivery_date, package_type_id, weight, contents_description);
                    System.out.println("");
                }
                    
            } catch (SQLException e){
                e.printStackTrace();
            }
            
            DBConnection.closeConnection(conn);
        } else {
            System.out.println("Connection test failed. Please check your database server and credentials.");
        }
    }
}
;