package com.g3w4.container_management_system.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g3w4.container_management_system.model.Customer;
import com.g3w4.container_management_system.service.CustomerService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/customer")
// @CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {


    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomersById(@PathVariable Integer id) {
        return customerService.getCustomersById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    
    @PostMapping
    public ResponseEntity<Customer> addCustomers(@RequestBody Customer customer) {
        // String regex = "[^a-zA-Z0-9 ]"; 
        // Pattern pattern = Pattern.compile(regex);
        // Matcher matcher = pattern.matcher(customer.getFirstName() + customer.getLastName() ); // Concat first last name
        // if(matcher.find()){
        //     return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        // }

        return ResponseEntity.ok(customerService.addCustomers(customer));

        
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomers(@PathVariable Integer id) {
        if (customerService.getCustomersById(id).isPresent()) {
            customerService.deleteCustomers(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    //  @PutMapping("/{id}")
    // public ResponseEntity<Container> updateContainer(@PathVariable Long id, @RequestBody Container containerDetails) {
    //     return customerService.getContainerById(id)
    //             .map(container -> {
    //                 container.setContainerName(containerDetails.getContainerName());
    //                 container.setWeight(containerDetails.getWeight());
    //                 container.setOriginId(containerDetails.getOriginId());
    //                 container.setDestinationId(containerDetails.getDestinationId());
    //                 return ResponseEntity.ok(containerService.updateContainer(container));
    //             }).orElse(ResponseEntity.notFound().build());
    // }
    
}
