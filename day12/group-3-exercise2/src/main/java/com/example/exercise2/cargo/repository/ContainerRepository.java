package com.example.exercise2.cargo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.example.exercise2.cargo.model.Container;

@Repository
public interface ContainerRepository extends JpaRepository <Container, Long>{
    List<Container> findByOrigin(String origin);
    List<Container> findByDestination(String destination);
    List<Container> findByWeightBetween(double minWeight, double maxWeight);

    @Query("SELECT c FROM Container c WHERE c.origin LIKE %?1%")
    List<Container> findByOriginContaining(String originPattern);

    @Query("SELECT c FROM Container c WHERE c.name LIKE %?1%")
    List<Container> findByName(String name);

}
