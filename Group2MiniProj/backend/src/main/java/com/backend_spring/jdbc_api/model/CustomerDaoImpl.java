package com.backend_spring.jdbc_api.model;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.backend_spring.jdbc_api.util.DbConnection;

public class CustomerDaoImpl implements CustomerDao {


    @Override
    public List<Customer> findAll() {
        Connection conn = DbConnection.getConnection();
        List<Customer> customers = new ArrayList<>();
        try {
            String sql = "SELECT * FROM customer;";
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt(1));
                customer.setFirstName(rs.getString("firstName"));
                customer.setLastName(rs.getString("lastName"));
                customers.add(customer);
            }

            return customers;
        } catch (Exception e) {
            // TODO: handle exception
        }
        
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

}
