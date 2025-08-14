package com.example.demo;

import java.lang.Thread.State;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;

public class DemoApplication {
    public static void main(String[] args) {
        createStatement();
        System.out.println("==========================END OF STATEMENT===================================");
        preparedStatement();
        System.out.println("==========================END OF PREPARED STATEMENT===================================");
        getCallableStatement();
         System.out.println("==========================END OF CALLABLE STATEMENT===================================");
    }

    public static void createStatement() {
         System.out.println("Hello!");

        Connection conn = DbConnection.getConnection();

        if (conn != null) {
            try {
                System.out.println("Connection test successful!");
                String sql = "SELECT * FROM couriers";

                Statement stmt = conn.createStatement(); 
                // stmt.setInt(1, 1);
                // stmt.execute();
                ResultSet rs = stmt.executeQuery(sql);
                
                while (rs.next()) {
                    int coourierId = rs.getInt("COURIER_ID");
                    String firstName = rs.getString("FIRST_NAME");
                    String lastName = rs.getString("LAST_NAME");
                    // int categoryId = rs.getInt("CATEGORY_ID");

                    System.out.printf("Courier ID: %d, First Name: %s, Last Name: %s%n",
                            coourierId, firstName, lastName);
                } 
                rs.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            DbConnection.closeConnection(conn);
        } else {
            System.out.println("Connection test failed. Please check your database server and credentials.");
        }
    }

    private static void preparedStatement() {
        System.out.println("Hello!");

        Connection conn = DbConnection.getConnection();

        if (conn != null) {
            try {
                System.out.println("Connection test successful!");
                String sql = "SELECT * FROM couriers";

                PreparedStatement stmt = conn.prepareStatement(sql); 
                // stmt.setInt(1, 1);
                stmt.execute();
                ResultSet rs = stmt.getResultSet();
                
                while (rs.next()) {
                    int coourierId = rs.getInt("COURIER_ID");
                    String firstName = rs.getString("FIRST_NAME");
                    String lastName = rs.getString("LAST_NAME");
                    // int categoryId = rs.getInt("CATEGORY_ID");

                    System.out.printf("Courier ID: %d, First Name: %s, Last Name: %s%n",
                            coourierId, firstName, lastName);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            DbConnection.closeConnection(conn);
        } else {
            System.out.println("Connection test failed. Please check your database server and credentials.");
        }
    }

    private static void getCallableStatement(){
        System.out.println("Hello!");

        Connection conn = DbConnection.getConnection();

        if (conn != null) {
            try {
                System.out.println("Connection test successful!");
                String sql = "{CALL GetCourierScorecard(1, ?, ?, ?, ?, ?, ?)}";

                CallableStatement callablestmt = conn.prepareCall(sql); 
                callablestmt.setInt(1, 1);
                // callablestmt.execute();
                // ResultSet rs = callablestmt.getResultSet();
                
                // while (rs.next()) {
                    // int coourierId = rs.getInt("COURIER_ID");
                    // String firstName = rs.getString("FIRST_NAME");
                    // String lastName = rs.getString("LAST_NAME");
                    // int categoryId = rs.getInt("CATEGORY_ID");
                    // System.out.printf("Courier ID: %d, First Name: %s, Last Name: %s%n",
                    //         coourierId, firstName, lastName);

                    callablestmt.registerOutParameter(1, Types.VARCHAR);
                    callablestmt.registerOutParameter(2, Types.INTEGER);
                    callablestmt.registerOutParameter(3, Types.INTEGER);
                    callablestmt.registerOutParameter(4, Types.DECIMAL);
                    callablestmt.registerOutParameter(5, Types.INTEGER);
                    callablestmt.registerOutParameter(6, Types.DECIMAL);

                    callablestmt.execute();
                    
                    String fullname = callablestmt.getString(1);
                    int totalDelivered = callablestmt.getInt(2);
                    int failedDeliveries = callablestmt.getInt(3);
                    double avgDeliveryTime = callablestmt.getDouble(4);
                    int cityCoverage = callablestmt.getInt(5);
                    double reliabilityScore = callablestmt.getDouble(6);

                     System.out.printf("Courier: %s%nDelivered: %d%nFailed: %d%nAvg Time: %.2f days%nCities: %d%nReliability: %.2f%n",
                    fullname, totalDelivered, failedDeliveries, avgDeliveryTime, cityCoverage, reliabilityScore);
                    callablestmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            DbConnection.closeConnection(conn);
        } else {
            System.out.println("Connection test failed. Please check your database server and credentials.");
        }
    }

}