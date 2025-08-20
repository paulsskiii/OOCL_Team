package com.example.excer2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Container {

    @Id
    private String containerNumber;
    private String origin;
    private String destination;
    private double weightKg;

}
