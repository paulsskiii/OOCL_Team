package com.capstone.cargo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.cargo.model.Container;
import org.springframework.stereotype.Repository;

@Repository
public interface ContainerRepository extends JpaRepository <Container, Long>{
    
}
