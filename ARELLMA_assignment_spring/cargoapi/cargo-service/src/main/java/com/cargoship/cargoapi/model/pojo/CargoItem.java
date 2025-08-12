// CargoItem.java (Model/POJO)
    // This class represents the data structure for a cargo item.

// src/main/java/com/example/cargoservice/model/CargoItem.java
package com.cargoship.cargoapi.model.pojo;

import jakarta.persistence.Entity; // Import for @Entity
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity // Marks this class as a JPA entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CargoItem {
    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates ID using database identity column
    private Long id;
    private String name;
    private double weight;
    private String origin;
    private String destination;
}


