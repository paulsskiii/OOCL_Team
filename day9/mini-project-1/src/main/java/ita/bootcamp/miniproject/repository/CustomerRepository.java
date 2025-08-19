package ita.bootcamp.miniproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import ita.bootcamp.miniproject.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    // Insert any query here that you guys want to customize
}
