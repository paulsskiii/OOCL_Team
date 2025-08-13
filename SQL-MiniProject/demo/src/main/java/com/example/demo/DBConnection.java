package com.example.demo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;

public class DBConnection {
    // @Value ("${db.schema}")
    public static String JDBC_SCHEMA = "online_ordering_proj";

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/" + JDBC_SCHEMA;

    // @Value ("${db.user}")
    private static String USER = "root";

    // @Value ("${db.password}")
    private static String PASSWORD = "";

    public static Connection getConnection () {


        Connection connection = null;
        try {
            connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            // System.out.println ("Database connection established");
        } catch (SQLException e) {
            System.out.println ("DB Connection failed!");
            System.out.println ("SQL State: " + e.getSQLState ());
            System.out.println ("Error Code: " + e.getErrorCode ());
            System.out.println ("Message: " + e.getMessage ());
            e.printStackTrace ();
        }

        return connection;
    }

    public static void displayCustomerDeliveryHistory (int customerID) {
        System.out.println ();
        Connection con = null;
        try {
            int nPackageCount = 0;
            String customerName = "";
            con = DBConnection.getConnection ();
            CallableStatement cstmt = null;
            String SQL = "CALL GetCustomerDeliveryHistory(?)";
            cstmt = con.prepareCall (SQL);
            cstmt.setInt (1, customerID);
            ResultSet rs = cstmt.executeQuery ();


            while (rs.next ()) {
                if (nPackageCount == 0) {
                    customerName = rs.getString("Customer");
                    System.out.println("Orders of customer: " + customerName + " | Customer ID: " + customerID + " =====");
                }
                int packageID = rs.getInt ("Package_Id");
                String deliveryDate = rs.getString ("Delivery Date");
                String packageType = rs.getString ("Package Type");
                String status = rs.getString ("status");
                String courier = rs.getString ("Courier");

                System.out.println ("Package ID: " + packageID);
                System.out.println ("\tDelivery Date: " + deliveryDate);
                System.out.println ("\tPackage Type: " + packageType);
                System.out.println ("\tStatus: " + status);
                System.out.println ("\tCourier: " + courier);
                nPackageCount++;
            }

            System.out.println ("\nTotal number of packages: " + nPackageCount);

            con.close ();
        } catch (SQLException e) {
            System.out.println ("DB Connection failed!");
            System.out.println ("SQL State: " + e.getSQLState ());
            System.out.println ("Error Code: " + e.getErrorCode ());
            System.out.println ("Message: " + e.getMessage ());
            e.printStackTrace ();
        }
    }

    public static void displayMostActiveCities () {
        Connection con = null;
        try {
            con = DBConnection.getConnection ();
            CallableStatement cstmt = null;
            String SQL = "";
            cstmt = con.prepareCall (SQL);
            ResultSet rs = cstmt.executeQuery ();

            while (rs.next ()) {
                
            }

            con.close ();
        } catch (SQLException e) {
            System.out.println ("DB Connection failed!");
            System.out.println ("SQL State: " + e.getSQLState ());
            System.out.println ("Error Code: " + e.getErrorCode ());
            System.out.println ("Message: " + e.getMessage ());
            e.printStackTrace ();
        }
    }

    public static void displayStepByStep (int packageID) {

    }

    public static void displayCourierScore (int courierID) {

    }
}
