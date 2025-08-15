package com.backend_spring.jdbc_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend_spring.jdbc_api.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {}