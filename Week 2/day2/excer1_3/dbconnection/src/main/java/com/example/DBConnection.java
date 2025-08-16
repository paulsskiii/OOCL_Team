package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class DBConnection {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/group3_miniproject";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        Connection connection = null;
        try{
            // Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Database connection established successfully!");
        }catch(SQLException e){
            System.err.println("Database connection failed!");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("Message: " + e.getMessage());

            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection connection){
        if (connection != null) {
            try{
                connection.close();
                System.out.println("Database connection closed successfully.");
            }catch(SQLException e){
                System.err.println("Error closing database connection!");
                System.err.println("SQLState: " + e.getSQLState());
                System.err.println("Error Code: " + e.getErrorCode());
                System.err.println("Message: " + e.getMessage());

                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws ClassNotFoundException{
        System.out.println("Attempting to get a database connection....");
        Connection conn = DBConnection.getConnection();
        if (conn != null) {
            System.out.println("Connection test successful!");

            String sql = "SELECT * FROM packages";

            try(Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)){ 

                while (rs.next()){
                    int id = rs.getInt("id");
                    LocalDate pickupDate = rs.getDate("pickup_date").toLocalDate();
                    LocalDate deliveryDate = rs.getDate("delivery_date").toLocalDate();
                    String packageType = rs.getString("package_type");
                    float weight = rs.getFloat("weight");
                    String contentDesc = rs.getString("contents_description");
                    int deliveryDetailsId = rs.getInt("delivery_details_id");
                    int courierId = rs.getInt("courier_id");

                    System.out.printf("Packages ID: %d, Packages: %s, Description: %s%n", id, packageType, contentDesc);
                }
            }catch(SQLException e){
                e.printStackTrace();
            }

        } else {
            System.out.println("Connection test failed. Please check your database server and credentials.");
        }
    }
}
