package com.example.demo.Statements;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.precious.medialibrary.util.DBConnection;

public class selectAll {

         Connection con = DBConnection.getConnection();

        try {
                
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

                    System.out.printf("Customer ID: %s, First Name: %s, Last Name: %s, Contact Number: %s, Email: %s, Address 1: %s, Address 2: %s, Location ID: %s\n",customer_id,first_name,last_name,contact_number,email_address,address_line1,address_line2,location_id);
                }

                con.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
    }
