package com.backend_spring.jdbc_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend_spring.jdbc_api.model.Customer;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:5173")
public class PackageStatus {
    //initialize

    @GetMapping("/user/{id}/status")
    public List<Customer> getCustomer() {
        return null;
    }
}
