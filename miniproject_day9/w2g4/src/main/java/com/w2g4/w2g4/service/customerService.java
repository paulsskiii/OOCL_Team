package com.w2g4.w2g4.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.w2g4.w2g4.exceptions.CustomerNotFoundException;
import com.w2g4.w2g4.model.Customer;
import com.w2g4.w2g4.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    // 1. Get all customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // 2. Get single customer by ID
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with ID " + id + " not found."));
    }

    // 3. Get customer count
    public long getCustomerCount() {
        return customerRepository.count();
    }

    
}
