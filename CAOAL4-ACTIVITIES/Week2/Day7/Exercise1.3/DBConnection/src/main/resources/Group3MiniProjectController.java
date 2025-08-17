package com.example.dbconnection;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class Group3MiniProjectController {

    private final CustomerRepository repository;

    public Group3MiniProjectController(CustomerRepository repository) {
        this.repository = repository;
    }

    // GET all customers
    @GetMapping
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    // GET customer by ID
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        return repository.findById(id);
    }

    // GET total customer count
    @GetMapping("/count")
    public int getCustomerCount() {
        return repository.getCustomerCount();
    }
}

