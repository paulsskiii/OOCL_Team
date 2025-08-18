package com.cargoship.cargoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository; // Import JpaRepository

import com.cargoship.cargoapi.model.CargoItem;

@Repository // Marks this as a Spring Data JPA repository
public interface CargoRepository extends JpaRepository<CargoItem, Long> {
    // Spring Data JPA automatically provides methods like:
    // save(), findById(), findAll(), deleteById(), existsById(), etc.
    // Custom query methods can be added here (e.g., findByOrigin)
}
