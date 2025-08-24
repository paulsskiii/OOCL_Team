package com.cargoship.cargoapi.model;

import jakarta.persistence.*;

/**
 * A basic model class for a Ship.
 */
@Entity
@Table(name = "Ship")
public class Ship {
    // TODO: Declare private fields (id, name, capacity, currentPort)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Double capacity;
    private String currentPort;

    // TODO: Add default constructor
    public Ship() {
    }

    // TODO: Add constructor with all fields
    public Ship(String name, Double capacity, String currentPort) {
        this.name = name;
        this.capacity = capacity;
        this.currentPort = currentPort;
    }
    
    // TODO: Add getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public String getCurrentPort() {
        return currentPort;
    }

    public void setCurrentPort(String currentPort) {
        this.currentPort = currentPort;
    }
    
    // TODO: Override toString() to return formatted ship data
    @Override
    public String toString() {
        return "Ship [id=" + id + ", name=" + name + ", capacity=" + capacity + ", currentPort=" + currentPort + "]";
    }

}
