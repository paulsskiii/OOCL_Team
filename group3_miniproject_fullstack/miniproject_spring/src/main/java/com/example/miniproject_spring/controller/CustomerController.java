package com.example.miniproject_spring.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.miniproject_spring.model.Customers;
import com.example.miniproject_spring.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class CustomerController {
    
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customers>> getAllCustomers(){
        return ResponseEntity.ok(customerService.getAllCustomers());
    }
    
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<Customers> getCustomerById(@PathVariable int customerId){
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }

    @GetMapping("/customerCount")
    public ResponseEntity<Long> getCustomerCount(){
        return ResponseEntity.ok(customerService.getCustomerCount());
    }
}