package com.cargoship.cargoapi.model;

public class Ship {
    private Long id;
    private String name;
    private double capacity;
    private String currentPort;

    public Ship() { }

    public Ship(Long id, String name, double capacity, String currentPort) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.currentPort = currentPort;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getCapacity() { return capacity; }
    public void setCapacity(double capacity) { this.capacity = capacity; }
    public String getCurrentPort() { return currentPort; }
    public void setCurrentPort(String currentPort) { this.currentPort = currentPort; }

    @Override
    public String toString() {
        return "Ship{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", currentPort='" + currentPort + '\'' +
                '}';
    }
}
