package com.example.demo.Statements;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.CallableStatement;

import com.precious.medialibrary.util.DBConnection;

public class Statements {

    public static void selectAll() {
        try {
            Connection con = DBConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM CUSTOMERS");

            while (rs.next()) {
                int customer_id = rs.getInt("customer_id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String contact_number = rs.getString("contact_number");
                String email_address = rs.getString("email_address");
                String address_line1 = rs.getString("address_line1");
                String address_line2 = rs.getString("address_line2");
                int location_id = rs.getInt("location_id");

                System.out.printf("Customer ID: %s, First Name: %s, Last Name: %s, Contact Number: %s, Email: %s, Address 1: %s, Address 2: %s, Location ID: %s\n",
                    customer_id, first_name, last_name, contact_number, email_address, address_line1, address_line2, location_id);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public static void trackPackageJourney() {
        try {
            Connection con = DBConnection.getConnection();
            CallableStatement stmt = con.prepareCall("{CALL TrackPackageJourney(?, ?, ?, ?, ?, ?, ?, ?)}");
            stmt.setInt(1, 1);
            stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
            stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
            stmt.registerOutParameter(4, java.sql.Types.VARCHAR);
            stmt.registerOutParameter(5, java.sql.Types.VARCHAR);
            stmt.registerOutParameter(6, java.sql.Types.VARCHAR);
            stmt.registerOutParameter(7, java.sql.Types.VARCHAR);
            stmt.registerOutParameter(8, java.sql.Types.TIMESTAMP);

            stmt.execute();

            String sender_name = stmt.getString(2);
            String recipient_name = stmt.getString(3);
            String courier_name = stmt.getString(4);
            String description = stmt.getString(5);
            String location = stmt.getString(6);
            String status = stmt.getString(7);
            java.sql.Timestamp timestamp = stmt.getTimestamp(8);

            System.out.printf("Sender: %s, Recipient: %s, Courier: %s, Description: %s, Location: %s, Status: %s, Timestamp: %s\n",
                sender_name, recipient_name, courier_name, description, location, status, timestamp);

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getCustomerDeliveryHistory(int input) {
        try {
            Connection con = DBConnection.getConnection();
            CallableStatement stmt = con.prepareCall("{CALL getCustomerDeliveryHistory(?)}");
            // ResultSet rs = stmt.execute();
            stmt.setInt(1, input);
            stmt.execute();
            ResultSet test = stmt.getResultSet();
            System.out.println();
            
            while (test.next()){
                String customer_name = test.getString("CUSTOMER_NAME");
                Integer total_sent = test.getInt("TOTAL_SENT");
                Integer total_received = test.getInt("TOTAL_RECEIVED");

                System.out.printf("Customer Name: %s, Total Sent: %d, Total Received: %d", 
                    customer_name, total_sent, total_received);
            }
            
            stmt.getMoreResults();
            ResultSet pkg_list = stmt.getResultSet();
            System.out.println();

            while(pkg_list.next()) {
                String transaction_type = pkg_list.getString("TRANSACTION_TYPE");
                Integer package_id = pkg_list.getInt("PACKAGE_ID");
                java.sql.Timestamp delivery_date = pkg_list.getTimestamp("DELIVERY_DATE");
                String pkg_type = pkg_list.getString("PACKAGE_TYPE");
                String pkg_status = pkg_list.getString("PACKAGE_STATUS");
                String courier_name = pkg_list.getString("COURIER_NAME");

                System.out.printf("Transaction Type: %s Package ID: %d Delivery Date: %s Package Type: %s Package Status: %s Courier Name: %s",
                    transaction_type, package_id, delivery_date, pkg_type, pkg_status, courier_name);
                System.out.println();
            } 

            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        

    }

    public static void MostActiveDeliveryCity(int input) {
        try {

            Connection con = DBConnection.getConnection();
            CallableStatement stmt = con.prepareCall("{CALL MostActiveDeliveryCity(?)}");
            stmt.setInt(1, input);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                String city = rs.getString("city");
                Integer total_packages = rs.getInt("total_packages");
                String most_frequent_courier = rs.getString("most_frequent_courier");
                Float avg_del_days = rs.getFloat("avg_delivery_days");
                
                System.out.printf("City: %s, Total Packages: %d, Most Frequent Courier: %s, Average Delivery Days: %.2f%n",city,total_packages,most_frequent_courier,avg_del_days);
            }
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
