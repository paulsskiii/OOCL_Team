package ita.bootcamp.miniproject.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import ita.bootcamp.miniproject.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    // Insert any query here that you guys want to customize
    List<Customer> findByFirstNameContainingIgnoreCase(String firstName);
    List<Customer> findByLastNameContainingIgnoreCase(String lastName);
    List<Customer> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstName, String lastName);

}
