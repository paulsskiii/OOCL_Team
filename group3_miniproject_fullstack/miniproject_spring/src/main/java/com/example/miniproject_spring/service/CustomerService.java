package com.example.miniproject_spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.miniproject_spring.model.Customers;
import com.example.miniproject_spring.model.Group3DAO;

@Service
public class CustomerService {
    Group3DAO group3DAO = new Group3DAO();

    public List<Customers> getAllCustomers(){
        return group3DAO.getStatementResultList("SELECT * FROM CUSTOMERS",Customers.class);
    }

    public Customers getCustomerById(int id){
        return group3DAO.getPreparedStatementSingleResultList("SELECT * FROM CUSTOMERS WHERE id = ?",Customers.class, id);
    }

    public Long getCustomerCount(){
        return getAllCustomers().stream().count();
    }

    
}