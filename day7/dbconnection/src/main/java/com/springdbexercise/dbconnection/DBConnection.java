package com.springdbexercise.dbconnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/cargo_shipping_system";
    // root@localhost:3306
    private static final String USER = "root";

    private static final String PASSWORD = "";


    public static Connection getConnection(){
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            System.out.println("Database connection established successfully!");
        } catch (SQLException e) {
            // TODO: handle exception
            System.err.println("Database connection failed!");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("Message: " + e.getMessage());

        }
        return connection;
    }

    public static void closeConnection (Connection connection){
        if (connection != null){
            try {
                connection.close();
                System.out.println("Database connection closed successfully");
            } catch (SQLException e) {
                // TODO: handle exception
                System.err.println("Error closing database connection!");
                System.err.println("SQLState: " + e.getSQLState());
                System.err.println("Error Code: " + e.getErrorCode());
                System.err.println("Message: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

// ----------------------------------------------------------------------------------------------------------------

    public static void retrieve_courier_name (Connection conn) {
        try {
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT first_name, last_name FROM courier");

            System.out.println("first_name\t\tlast_name");
            while (rs.next()) {
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                System.out.println(first_name + "\t\t\t" + last_name );
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException("Error", e);
        }
    }

    public static void retrieve_all_sender_package (Connection conn) {
        try {
            String query = "SELECT * FROM package INNER JOIN customer ON package.sender_id = customer.customer_id WHERE package.sender_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,1);

            ResultSet rs = pstmt.executeQuery();
            
            System.out.println("package_id\tfirst_name\tlast_name");
            while (rs.next()) {
                int package_id = rs.getInt("package_id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                System.out.println(package_id + "\t\t" + first_name + "\t\t" + last_name );
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException("Error", e);
        }
    }

    public static void retrieve_courier_details(Connection conn) {
        try {
            String query = "{CALL retrieve_courier_details(?)}";
            CallableStatement cstmt = conn.prepareCall(query);
            cstmt.setInt(1, 12);

            ResultSet rs = cstmt.executeQuery();
            
            System.out.println("courier_id\tfirst_name\tlast_name\tvehicle_type");
            while (rs.next()) {
                int package_id = rs.getInt("courier_id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String vehicle_type = rs.getString("vehicle_type");
                System.out.println(package_id + "\t\t" + first_name + "\t\t" + last_name + "\t\t" + vehicle_type);
            }
            rs.close();
            cstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException("Error", e);
        }
    }

    public static void most_active_delivery_cities(Connection conn) {
        try {
            String query = "{CALL most_active_delivery_cities()}";
            CallableStatement cstmt = conn.prepareCall(query);
            // cstmt.setInt(1, 12);

            ResultSet rs = cstmt.executeQuery();
            
            
            while (rs.next()) {
                String city = rs.getString("city_name");
                int pkg_delivered = rs.getInt("packages_delivered");
                String courier = rs.getString("most_frequent_courier");
                float avg = rs.getFloat("avg_delivery_time_days");
                System.out.printf("City: %s \nPackages Delivered: %s \nMost Frequent Courier: %s \naAVG Delivery Time: %s \n", city, pkg_delivered, courier, avg);
                System.out.println("---------------------------------------------------");
            }
            rs.close();
            cstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException("Error", e);
        }
    }



    public static void main (String[] args){
        System.out.println("Attempting to get a database connection...");
        Connection conn = DBConnection.getConnection();
        if(conn != null){
            System.out.println("Connection test successful!");
            
            // retrieve_all_sender_package(conn);
            // retrieve_courier_details(conn);
            most_active_delivery_cities(conn);



            /*
            String sql = "SELECT * FROM package";

            
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)){                
                    
                while(rs.next()){
                    int package_id = rs.getInt("package_id");
                    String pickup_date = rs.getString("pickup_date");
                    String delivery_date = rs.getString("delivery_date");
                    int package_type_id = rs.getInt("package_type_id");
                    float weight = rs.getFloat("weight");
                    String contents_description = rs.getString("contents_description");
                    int sender_id = rs.getInt("sender_id");
                    int recipient_id = rs.getInt("recipient_id");
                    String created_at = rs.getString("created_at");

                    System.out.printf("packageId: %s | pickup_date: %s | delivery_date: %s | package_type_id: %s | weight: %s | content: %s", 
                    package_id, pickup_date, delivery_date, package_type_id, weight, contents_description);
                    System.out.println("");
                }
                    
            } catch (SQLException e){
                e.printStackTrace();
            }
            */
            
            DBConnection.closeConnection(conn);
        } else {
            System.out.println("Connection test failed. Please check your database server and credentials.");
        }
    }
}
;