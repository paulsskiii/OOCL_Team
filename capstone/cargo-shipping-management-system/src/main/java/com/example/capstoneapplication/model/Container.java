package com.example.capstoneapplication.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="container")
public class Container {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;

    @Column(name ="container_name")
    private String containerName;

    @Column(name ="weight")
    private double weight; // in kg

    @Column(name ="origin")
    private String origin;

    @Column(name ="destination")
    private String destination;

    public Container (String containerName, double weight, String origin, String destination) {
        this.containerName=containerName;
        this.weight=weight;
        this.origin=origin;
        this.destination=destination;
    }

}
