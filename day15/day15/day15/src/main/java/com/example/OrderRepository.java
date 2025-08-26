package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.day15.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
