package com.example.demo;

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

    public static void getStatement () {
        Statement stmt = null;

        try {
            Connection con = DBConnection.getConnection ();
            String SQL = "SELECT * FROM vehicleTypes";
            stmt = con.createStatement ();
            ResultSet rs = stmt.executeQuery (SQL);

            while (rs.next ()) {
                System.out.println();
                int id = rs.getInt("id");
                String vehName = rs.getString ("name");

                System.out.print("Vehicle ID: " + id + " | Vehicle Name: " + vehName);
            }
        } catch (SQLException e) {
            System.out.println ("DB Connection failed!");
            System.out.println ("SQL State: " + e.getSQLState ());
            System.out.println ("Error Code: " + e.getErrorCode ());
            System.out.println ("Message: " + e.getMessage ());
            e.printStackTrace ();
        }

        System.out.println ();
    }

    public static void getPrep (int senderId) {
        PreparedStatement pstmt = null;


        try {
            Connection con = DBConnection.getConnection ();
            String SQL = "SELECT * FROM package WHERE package.senderId=?";
            pstmt = con.prepareStatement (SQL);
            pstmt.setInt (1, senderId);
            ResultSet rs = pstmt.executeQuery ();

            while (rs.next ()) {
                System.out.println();
                int id = rs.getInt("id");
                String desc = rs.getString ("contentsDescription");
                int sendId = rs.getInt ("senderId");

                System.out.print("Package ID: " + id + " | Sender ID: " + sendId + " | Package Description: " + desc);
            }
        } catch (SQLException e) {
            System.out.println ("DB Connection failed!");
            System.out.println ("SQL State: " + e.getSQLState ());
            System.out.println ("Error Code: " + e.getErrorCode ());
            System.out.println ("Message: " + e.getMessage ());
            e.printStackTrace ();
        }

        System.out.println ();
    }

    public static void getCall (int senderId) {
        CallableStatement cstmt = null;
        try {
            Connection con = DBConnection.getConnection ();
            String SQL = "CALL get_package_of_sender (?)";
            cstmt = con.prepareCall(SQL);
            cstmt.setInt (1, senderId);
            ResultSet rs = cstmt.executeQuery ();

            while (rs.next ()) {
                System.out.println();
                int id = rs.getInt("id");
                String desc = rs.getString ("contentsDescription");
                int sendId = rs.getInt ("senderId");

                System.out.print("Package ID: " + id + " | Sender ID: " + sendId + " | Package Description: " + desc);
            }
        } catch (SQLException e) {
            System.out.println ("DB Connection failed!");
            System.out.println ("SQL State: " + e.getSQLState ());
            System.out.println ("Error Code: " + e.getErrorCode ());
            System.out.println ("Message: " + e.getMessage ());
            e.printStackTrace ();
        }

        System.out.println ();
    }
}

