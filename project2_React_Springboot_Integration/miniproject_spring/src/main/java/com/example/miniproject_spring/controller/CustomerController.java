package com.example.miniproject_spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.miniproject_spring.model.Customers;
import com.example.miniproject_spring.service.CustomerService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api")

public class CustomerController {
    
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/customers")
    public ResponseEntity<List<Customers>> getAllCustomers(){
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<Customers> getCustomerById(@PathVariable int customerId){
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }

    @GetMapping("/customerCount")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<Map<String, Long>> getCustomerCount() {
        return ResponseEntity.ok(Map.of("count", customerService.getCustomerCount()));
    }

}