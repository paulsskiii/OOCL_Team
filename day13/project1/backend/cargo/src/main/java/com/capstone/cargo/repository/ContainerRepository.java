package com.capstone.cargo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.cargo.model.Container;

import java.util.Optional;

public interface ContainerRepository extends JpaRepository <Container, Long>{
    Optional<Container> findByOwner(String name);
}
