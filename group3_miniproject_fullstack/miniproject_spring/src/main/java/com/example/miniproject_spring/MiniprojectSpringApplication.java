package com.example.miniproject_spring;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MiniprojectSpringApplication {
 private static final String JDBC_URL = "jdbc:mysql://localhost:3306/group3_miniproject";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            System.out.println("Database connection established successfully!");
        } catch (SQLException e) {
            System.err.println("Database connection failed!");
            System.err.println("SQL State: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("Message: " + e.getMessage());
            
            e.printStackTrace();
        }

        return connection;
    }

    public static void closeConnection(Connection connection){

        if(connection!=null){
            try {
                connection.close();
                System.out.println("Database Connection closed successfully!");
            } catch (SQLException e) {

                System.err.println("Error closing database connection!");
                System.err.println("SQL State: " + e.getSQLState());
                System.err.println("Error Code: " + e.getErrorCode());
                System.err.println("Message: " + e.getMessage());

                e.printStackTrace();
            }
        }

    }


    public static void main(String[] args){
        System.out.println("Attempting to get database connection...");
        Connection conn = MiniprojectSpringApplication.getConnection();

        if(conn != null){

            //CALLABLE STATEMENT - for group3_miniproject
            try{
                CallableStatement cstmt = conn.prepareCall("{CALL getMostActiveDeliveryCities()}");

                ResultSet rs = cstmt.executeQuery();

                while(rs.next()){
                    String activeCities = rs.getString("Active Delivery Cities");
                    int totalDelivered = rs.getInt("No. of Packages Delivered");
                    String mostFreqCourier = rs.getString("Most Frequent Courier");
                    float averageDelivered = rs.getFloat("Average Delivery Day/s");

                    System.out.println("-------------------------");
                    System.out.printf("Active Cities: %s%nTotal Delivered: %d%nMost Freq Courier: %s%nAverage Delivery Time: %.2f days%n",
                            activeCities, totalDelivered, mostFreqCourier, averageDelivered);

                }
                cstmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            closeConnection(conn);

        }
    }

}
