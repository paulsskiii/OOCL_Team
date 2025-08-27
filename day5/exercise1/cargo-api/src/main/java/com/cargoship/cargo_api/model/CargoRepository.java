package com.cargoship.cargo_api.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository <CargoItem, Long> {
    // Spring Data JPA automatically provides methods like:
    // save(), findById(), findAll(), deleteById(), existsById(), etc.
    // Custom query methods can be added here (e.g., findByOrigin)
}
