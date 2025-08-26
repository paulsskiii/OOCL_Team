package com.example.day15test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.day15test.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
