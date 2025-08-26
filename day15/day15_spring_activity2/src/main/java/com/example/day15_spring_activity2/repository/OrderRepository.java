package com.example.day15_spring_activity2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.day15_spring_activity2.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>  {
    
}
