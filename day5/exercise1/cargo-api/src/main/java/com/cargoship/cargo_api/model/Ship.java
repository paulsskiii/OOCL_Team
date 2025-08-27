package com.cargoship.cargo_api.model;


public class Ship {
    private int id;
    private String name;
    private double capacity;
    private String currentPort;

    public Ship(int id) {
        this.id = id;
    }

    public Ship(int id, String name, double capacity, String currentPort) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.currentPort = currentPort;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public void setCurrentPort(String currentPort) {
        this.currentPort = currentPort;
    }

    public int getId() {
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

    @Override
    public String toString() {
        return getId() + " " + getName() + " " + getCapacity() + " " + getCurrentPort();
    }
}
