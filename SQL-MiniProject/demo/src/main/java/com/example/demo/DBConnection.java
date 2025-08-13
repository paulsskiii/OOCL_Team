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
        System.out.println ();
        Connection con = null;
        try {
            con = DBConnection.getConnection ();
            CallableStatement cstmt = null;
            String SQL = "CALL getMostActiveDeliveryCities()";
            cstmt = con.prepareCall (SQL);
            ResultSet rs = cstmt.executeQuery ();

            while (rs.next ()) {
                String locationName = rs.getString ("Location Name");
                int freq = rs.getInt ("Frequency");
                String courier = rs.getString ("Most Frequent Courier");
                String deliveryDate = rs.getString ("Delivery Date Average");

                System.out.println ("Location: " + locationName);
                System.out.println ("\tNumber of deliveries: " + freq);
                System.out.println ("\tMost frequency courier: " + courier);
                System.out.println ("\tAverage Delivery Date: " + deliveryDate);
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
       System.out.println ();
        Connection con = null;
        try {
            boolean isFirst = true;
            con = DBConnection.getConnection ();
            CallableStatement cstmt = null;
            String SQL = "CALL getPackageJourneyTracker(?)";
            cstmt = con.prepareCall (SQL);
            cstmt.setInt (1, packageID);
            ResultSet rs = cstmt.executeQuery ();


            while (rs.next ()) {
                if (isFirst) {
                    System.out.println("Step-by-step of Package ID: " + packageID);
                    System.out.println ("With description: " + rs.getString("package_contents_description"));
                    System.out.println ("Sender: " + rs.getString ("sender_name") + " | Receiver: " + rs.getString ("receiver_name"));
                    isFirst = false;
                }
                String trackingEventDescription = rs.getString ("tracking_event_description");
                String status = rs.getString ("package_status");
                String courier = rs.getString ("courier_name");
                String location = rs.getString ("location_name");
                String updateDate = rs.getString ("update_ts");

                System.out.println ("Event: " + trackingEventDescription);
                System.out.println ("\tCourier: " + courier);
                System.out.println ("\tLocation: " + location);
                System.out.println ("\tStatus: " + status);
                System.out.println ("\tUpdated on: " + updateDate);
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

    public static void displayCourierScore (int courierID) {

    }
}
