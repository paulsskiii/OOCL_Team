package com.example.capstoneapplication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.capstoneapplication.model.Container;

@Repository
public interface ContainerRepository extends JpaRepository<Container, Long> {

    public Optional<Container> findByName(String name);

    List<Container> findByDestinationAndArrivalDate(String destination, String arrivalDate);
    
}
