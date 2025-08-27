package com.capstone.cargo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.cargo.model.Container;

public interface ContainerRepository extends JpaRepository <Container, Long>{
    
}
