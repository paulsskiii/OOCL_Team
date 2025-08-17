package com.example.dbconnection;

import java.sql.*;

public class Group3MiniProject {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/group3_miniproject";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "AAlleexx123!";

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
        Connection conn = Group3MiniProject.getConnection();

//        if(conn != null){
//
//            //CALLABLE STATEMENT - for group3_miniproject
//            try{
//                CallableStatement cstmt = conn.prepareCall("{CALL getMostActiveDeliveryCities()}");
//
//                ResultSet rs = cstmt.executeQuery();
//
//                while(rs.next()){
//                    String activeCities = rs.getString("Active Delivery Cities");
//                    int totalDelivered = rs.getInt("No. of Packages Delivered");
//                    String mostFreqCourier = rs.getString("Most Frequent Courier");
//                    float averageDelivered = rs.getFloat("Average Delivery Day/s");
//
//                    System.out.println("-------------------------");
//                    System.out.printf("Active Cities: %s%nTotal Delivered: %d%nMost Freq Courier: %s%nAverage Delivery Time: %.2f days%n",
//                            activeCities, totalDelivered, mostFreqCourier, averageDelivered);
//
//                }
//                cstmt.close();
//            }catch (SQLException e){
//                e.printStackTrace();
//            }
//            closeConnection(conn);
//        }


        //GETAllCustomers
        if (conn != null) {
            System.out.println("Connection test successful");

            //STATEMENT

            String statementSql = "SELECT * FROM Customers";
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(statementSql)) {

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    String contactNo = rs.getString("contact_number");
                    String emailAdd = rs.getString("email_address");
                    String address1 = rs.getString("address_line1");
                    String address2 = rs.getString("address_line2");
                    String barangay = rs.getString("barangay");
                    String city = rs.getString("city");
                    int postalCode = rs.getInt("postal_code");
                    String region = rs.getString("region");
                    String country = rs.getString("country");
                    LocalDate createdAt = rs.getDate("created_at").toLocalDate();
                    LocalDate updatedAt = rs.getDate("updated_at").toLocalDate();

                    System.out.printf("Customer ID: %d%nName: %s%nContact No.: %s%nEmail Address: %s%nAddress: %s%nBarangay, City: %s%s%d%nRegion, Country: %s%n",
                            id, (firstName + lastName), contactNo, emailAdd, (address1 + address2), (barangay + city + postalCode), (region + country));
                }
              stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Connection test failed. Please check your database server and credentials.");
        }




    }
}
