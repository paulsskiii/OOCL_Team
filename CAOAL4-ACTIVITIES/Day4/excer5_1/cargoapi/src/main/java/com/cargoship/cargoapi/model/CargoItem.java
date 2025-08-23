// CargoItem.java (Model/POJO)
    // This class represents the data structure for a cargo item.

// src/main/java/com/example/cargoservice/model/CargoItem.java
package com.cargoship.cargoapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data; // From Lombok for getters/setters/equals/hashCode/toString
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data // Generates getters, setters, equals, hashCode, and toString methods
@NoArgsConstructor // Generates a no-argument constructor
@AllArgsConstructor // Generates a constructor with all fields
@Entity
public class CargoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double weight; // in kg
    private String origin;
    private String destination;

    // added a constructor
//    public CargoItem() {}
//
//    public CargoItem(Long id, String name, double weight, String origin, String destination) {
//        this.id = id;
//        this.name = name;
//        this.weight = weight;
//        this.origin = origin;
//        this.destination = destination;
//    }
}


