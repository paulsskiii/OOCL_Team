package com.jdbc.exercise.jdcbexercise.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/group3_miniproject";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection(){
     Connection con = null;
        try{
            con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            System.out.println("Connected successfully");
            System.out.println("------------------------------------------------");
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return con;
    }

    public static void closeConnection(Connection con){
        if(con != null)
        try{
            con.close();
            System.out.println("------------------------------------------------");
            System.out.println("Connection closed");
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
