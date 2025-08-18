package com.example.miniproject_spring.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/group3_miniproject";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection(){
     Connection con = null;
        try{
            con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return con;
    }

    public static void closeConnection(Connection con){
        if(con != null)
        try{
            con.close();
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
