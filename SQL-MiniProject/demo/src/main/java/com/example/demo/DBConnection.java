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
    private static String JDBC_SCHEMA = "online_ordering_proj";

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/" + JDBC_SCHEMA;

    // @Value ("${db.user}")
    private static String USER = "root";

    // @Value ("${db.password}")
    private static String PASSWORD = "";

    public static Connection getConnection () {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            System.out.println ("Database connection established");
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
        Connection con = null;
        try {
            con = DBConnection.getConnection ();
            CallableStatement cstmt = null;
            String SQL = "";
            cstmt = con.prepareCall (SQL);
            cstmt.setInt (1, customerID);
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
}
