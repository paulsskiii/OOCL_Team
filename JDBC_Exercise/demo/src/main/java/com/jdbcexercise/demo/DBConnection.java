package com.jdbcexercise.demo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/online_ordering_proj";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
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
        if(connection != null){
            try{
                connection.close();
                System.out.println("Database connection closed successfully!");
            } catch(SQLException e){
            System.err.println("Error closing database connection!");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("Message: " + e.getMessage());
            e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        CallableStatement cstmt = null;
        if(conn != null){
            System.out.println("Connection test successfull");
            String sql = "SELECT * FROM courier";

            try(Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
                while (rs.next()) {
                    // int packageId = rs.getInt("id");
                    // int packageWeight = rs.getInt("weight");
                    // String packageDescription = rs.getString("contentsDescription");
                    // int packageTypesId = rs.getInt("packageTypesId");

                    // System.out.printf("Package ID: %d, Weight: %d, Package Type ID: %d%n", packageId,packageWeight,packageTypesId);

                    String fName = rs.getString("firstName");
                    String lName = rs.getString("lastName");
                    System.out.printf("%s %s%n", fName,lName);
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }

        try{
            String prepSQL = "SELECT * FROM package WHERE senderId = ?";
            pstmt = conn.prepareStatement(prepSQL);

            pstmt.setInt(1, 1);

            ResultSet prs = pstmt.executeQuery();
            while (prs.next()) {
                    int packageId = prs.getInt("id");
                    String deliveryDate = prs.getString("deliveryDate");
                    float weight = prs.getFloat("weight");
                    System.out.printf("%d, %s, %.2f%n", packageId, deliveryDate, weight);
                }
        }catch(SQLException e){
            e.printStackTrace();
        }

        try{
            String callSQL = "{CALL GetCustomerDeliveryHistory(?)}";
            cstmt = conn.prepareCall(callSQL);

            cstmt.setInt(1, 1);

            ResultSet crs = cstmt.executeQuery();
            while (crs.next()) {
                    String customerName = crs.getString("Customer");
                    int packageId = crs.getInt("Package_Id");
                    String deliveryDate = crs.getString("Delivery Date");
                    String packageType = crs.getString("Package Type");
                    String status = crs.getString("Status");
                    String courier = crs.getString("Courier");
                    System.out.printf("%s, %d, %s, %s, %s%n",customerName, packageId,deliveryDate, packageType, status,courier);
                }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
