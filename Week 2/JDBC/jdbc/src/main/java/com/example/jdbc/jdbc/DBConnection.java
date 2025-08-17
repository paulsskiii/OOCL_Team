package com.example.jdbc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


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

}