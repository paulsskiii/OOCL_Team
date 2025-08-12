// Create CargoRepository.java (JPA Repository Interface)

// src/main/java/com/example/cargoservice/repository/CargoRepository.java
package com.cargo.cargo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository; // Import JpaRepository

@Repository // Marks this as a Spring Data JPA repository
public interface CargoRepository extends JpaRepository<CargoItem, Long> {
    // Spring Data JPA automatically provides methods like:
    // save(), findById(), findAll(), deleteById(), existsById(), etc.
    // Custom query methods can be added here (e.g., findByOrigin)
}
