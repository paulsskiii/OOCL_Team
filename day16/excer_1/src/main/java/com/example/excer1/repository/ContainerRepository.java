package com.example.excer1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.excer1.model.Container;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContainerRepository extends JpaRepository<Container, String> {

    public Optional<List<Container>> findByContainerNumber(String containerNumber);

    public Optional<List<Container>> findByOrigin(String origin);

    public Optional<List<Container>> findByDestination(String destination);
}
