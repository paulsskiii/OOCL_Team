package com.w2g4.w2g4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.w2g4.w2g4.model.Customer;

@Repository
public interface customerRepository extends JpaRepository<Customer, Long> {
    
}
