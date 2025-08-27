package com.example.excer1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Container {

    @Id
    private String containerNumber;
    private String origin;
    private String destination;
    private double weightKg;

}
