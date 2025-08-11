package com.cargoship.cargoapi.model;

/**
 * A basic model class for a Ship.
 */
public class Ship {
    // TODO: Declare private fields (id, name, capacity, currentPort)
    private Long id;
    private String name;
    private double capacity;
    private String currentPort;

    // TODO: Add default constructor
    public Ship() {};

    // TODO: Add constructor with all fields
    public Ship(Long id, String name, double capacity, String currentPort) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.currentPort = currentPort;
    }

    // TODO: Add getters and setters
    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getCapacity() {
        return this.capacity;
    }

    public String getCurrentPort() {
        return this.currentPort;
    }

    // TODO: Override toString() to return formatted ship data
    @Override
    public String toString() {
        return "ID: " + this.id + 
            " | Name: " + this.name + 
            " | Capacity: " + this.capacity + 
            " | Current Port: " + this.currentPort;
            // + "\n";
    }
}
