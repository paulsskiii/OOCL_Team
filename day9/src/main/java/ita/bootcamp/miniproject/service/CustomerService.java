package ita.bootcamp.miniproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ita.bootcamp.miniproject.model.Customer;
import ita.bootcamp.miniproject.repository.CustomerRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    // VIEW CUSTOMER
    public Customer findCustomer(int id) {
        return customerRepository.findById(id).orElse(null);
    }

    public List<Customer> viewAllCustomer() {
        return customerRepository.findAll();
    }

    // CREATE CUSTOMER
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // UPDATE CUSTOMER
    public Customer updateCustomer(int id, Customer customer) {
        Customer foundCustomer = customerRepository.findById(id).orElse(null);
        if (foundCustomer != null) {
            foundCustomer.setFirstName(customer.getFirstName());
            foundCustomer.setLastName(customer.getLastName());
            foundCustomer.setContactNumber(customer.getContactNumber());
            foundCustomer.setEmailAddress(foundCustomer.getEmailAddress());
            foundCustomer.setAddressLine1(foundCustomer.getAddressLine1());
            foundCustomer.setAddressLine2(foundCustomer.getAddressLine2());
            foundCustomer.setLocationId(foundCustomer.getLocationId());
            return customerRepository.save(foundCustomer);
        }
        return null;
    }

    // DELETE CUSTOMER
    public boolean deleteCustomer(int id) {
        Customer foundCustomer = customerRepository.findById(id).orElse(null);
        if (foundCustomer != null) {
            customerRepository.delete(foundCustomer);
            return true;
        }
        ;
        return false;
    }

    // COUNT CUSTOMER
    public Long findCustomerCount(){
        return customerRepository.count();
    }

}
