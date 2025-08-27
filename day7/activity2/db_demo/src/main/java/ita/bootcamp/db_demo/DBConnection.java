package ita.bootcamp.db_demo;


import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.Scanner;

public class DBConnection {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/cgoshipping";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            System.out.println("Database connection established.");
            return conn;
        }catch(SQLException e){
            System.err.println("Database connection could not be established.");
            System.err.println(e.getSQLState());
            System.err.println(e.getErrorCode());
            System.err.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static void closeConnection(Connection conn) {
        if(conn != null){
            try{
                conn.close();
                System.out.println("Database is closed bro");
            } catch (SQLException e) {
                System.err.println("Database connection could not be established.");
                System.err.println(e.getSQLState());
                System.err.println(e.getErrorCode());
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static void getAllCustomers(Connection conn) {
        ResultSet resultSet = null;
        if(conn != null){
            try{
                String sqlStatement = "SELECT * FROM CUSTOMERS;";
                Statement statement = conn.createStatement();

                resultSet = statement.executeQuery(sqlStatement);

                while(resultSet.next()){
                    int id = resultSet.getInt("CUSTOMER_ID");
                    String name = resultSet.getString("FIRST_NAME") + " " + resultSet.getString("LAST_NAME");
                    String contactNo = resultSet.getString("CONTACT_NUMBER");
                    String email = resultSet.getString("EMAIL_ADDRESS");
                    System.out.println("Record ID: " + id + " Name: " + name + " Contact: " + contactNo + " Email: " + email);

                }
                statement.close();

            } catch (SQLException e) {
                System.err.println("Database connection could not be established.");
                System.err.println(e.getSQLState());
                System.err.println(e.getErrorCode());
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static void getSpecificCustomer(Connection conn) {
        ResultSet resultSet = null;
        Scanner scanner = new Scanner(System.in);
        if(conn != null){
            try{

                System.out.println("Input Customer ID to search: ");
                int id = scanner.nextInt();

                String sqlStatement = "SELECT * FROM CUSTOMERS WHERE CUSTOMER_ID = " + id;
                Statement statement = conn.createStatement();

                resultSet = statement.executeQuery(sqlStatement);

                while(resultSet.next()){
                    int customerId = resultSet.getInt("CUSTOMER_ID");
                    String name = resultSet.getString("FIRST_NAME") + " " + resultSet.getString("LAST_NAME");
                    String contactNo = resultSet.getString("CONTACT_NUMBER");
                    String email = resultSet.getString("EMAIL_ADDRESS");
                    System.out.println("Customer ID: " + customerId + " Name: " + name + " Contact: " + contactNo + " Email: " + email);

                }
                statement.close();

            } catch (SQLException e) {
                System.err.println("Database connection could not be established.");
                System.err.println(e.getSQLState());
                System.err.println(e.getErrorCode());
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Connection conn = DBConnection.getConnection();
        ResultSet resultSet = null;
        if(conn != null){
            System.out.println("It worked bro");

            getAllCustomers(conn);

            getSpecificCustomer(conn);

            closeConnection(conn);

            //@Value({$env.jdbc_url})
            //String url

            //System.out.println(url);
        }else {
            System.out.println("It did not work bro");
        }

    }

}
