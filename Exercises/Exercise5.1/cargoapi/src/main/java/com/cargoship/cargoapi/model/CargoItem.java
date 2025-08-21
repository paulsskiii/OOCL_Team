// CargoItem.java (Model/POJO)
    // This class represents the data structure for a cargo item.

// src/main/java/com/example/cargoservice/model/CargoItem.java
package com.cargoship.cargoapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor; // From Lombok for getters/setters/equals/hashCode/toString
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // Generates getters, setters, equals, hashCode, and toString methods
@NoArgsConstructor // Generates a no-argument constructor
@AllArgsConstructor // Generates a constructor with all fields
public class CargoItem {
    @Id
    private Long id;
    private String name;
    private double weight; // in kg
    private String origin;
    private String destination;
}


