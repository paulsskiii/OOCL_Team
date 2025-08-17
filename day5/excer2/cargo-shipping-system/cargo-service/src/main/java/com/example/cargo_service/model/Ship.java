package com.example.cargo_service.model;
/**
 * A basic model class for a Ship.
 */
public class Ship {
    // TODO: Declare private fields (id, name, capacity, currentPort)
    private String id;
    private String name;
    private double capacity;
    private String currentPort;

    // TODO: Add default constructor
    public Ship() {}

    // TODO: Add constructor with all fields
    public Ship( String id, String name, double capacity, String currentPort) {
        // Default constructor
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.currentPort = currentPort;
    }

    // TODO: Add getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
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
        return "Ship{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", currentPort='" + currentPort + '\'' +
                '}';
    }
}