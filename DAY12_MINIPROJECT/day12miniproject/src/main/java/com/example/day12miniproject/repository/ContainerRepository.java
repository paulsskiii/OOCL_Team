package com.example.day12miniproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.day12miniproject.model.Container;

@Repository
public interface ContainerRepository extends JpaRepository<Container, Long> {
    
}
