package com.g3w4.container_management_system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g3w4.container_management_system.repository.CustomerRepository;
import com.g3w4.container_management_system.model.Customer;

@Service
public class CustomerService {
    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    } 

    public Optional<Customer> getCustomersById(Integer id) {
        return customerRepository.findById(id); // Uses JpaRepository's findById()
    }

    public Customer addCustomers(Customer customer) {
        return customerRepository.save(customer); // Uses JpaRepository's save() for create/update
    }

    public void deleteCustomers(Integer id) {
        customerRepository.deleteById(id); // Uses JpaRepository's deleteById()
    }
}
