package com.group1.capstone.repository;

import com.group1.capstone.model.Container;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContainerRepository extends JpaRepository<Container, String> {

    public Optional<List<Container>> findByContainerNumber(String containerNumber);

    public Optional<List<Container>> findByOrigin(String origin);

    public Optional<List<Container>> findByDestination(String destination);
}
