package com.example.excer2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.excer2.model.Container;
import java.util.List;


@Repository
public interface ContainerRepository extends JpaRepository <Container, String> {

    public List<Container> findByContainerNumber(String containerNumber);
}
