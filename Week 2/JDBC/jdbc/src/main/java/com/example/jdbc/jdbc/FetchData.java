package com.example.jdbc.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchData {
    private Connection conn;    
    //test normal querying
    public void testNormalQuery(){
        
        try {
            conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from customer");

            System.out.println("NORMAL QUERY:");
            while (rs.next()) {
                System.out.println("Customer " + rs.getInt(1)+ " is " +rs.getString(2) + " " + rs.getString(3) );
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Something went wrong!: " + e);
        }
    }

    public void testStoredProcedure(){
        try {
            conn = DBConnection.getConnection();
            CallableStatement stmt = conn.prepareCall("{CALL getCourierScoreCard(?)}");
            stmt.setInt(1, 1);
            boolean iResultSet = stmt.execute();

            System.out.println("STORED PROCEDURE:");

            while (iResultSet) {
                ResultSet rs = stmt.getResultSet();

                while (rs.next()) {
                    System.out.println("Result: "+rs.getString(1));
                }

                rs.close();

                iResultSet = stmt.getMoreResults();
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Something went wrong!: " + e);
        }
    }
}
