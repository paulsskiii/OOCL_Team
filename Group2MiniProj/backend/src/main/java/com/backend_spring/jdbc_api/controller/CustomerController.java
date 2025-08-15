package com.backend_spring.jdbc_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend_spring.jdbc_api.model.Customer;
import com.backend_spring.jdbc_api.model.CustomerDao;
import com.backend_spring.jdbc_api.model.CustomerDaoImpl;
import com.backend_spring.jdbc_api.util.DbConnection;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:5173")
public class CustomerController {

    private CustomerDao customerDao = new CustomerDaoImpl() ;
    
    @GetMapping("/users")
    public List<Customer> getMethodName() {
        DbConnection.getConnection();
        return customerDao.findAll();
    }
}
