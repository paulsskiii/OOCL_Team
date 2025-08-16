package com.cargoship.cargoapi.model;

/**
 * A basic model class for a Ship.
 */
public class Ship {
    // TODO: Declare private fields (id, name, capacity, currentPort)
    private long id;
    private String name;
    private int capacity;
    private String currentPort;

    // TODO: Add default constructor
    public Ship(){}

    // TODO: Add constructor with all fields
    public Ship(long id, String name, int capacity, String currentPort){
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.currentPort = currentPort;
    }

    // TODO: Add getters and setters
    
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getCurrentPort(){
        return currentPort;
    }


    public void setId(long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

    public void setCurrentPort(String currentPort){
        this.currentPort = currentPort;
    }

    // TODO: Override toString() to return formatted ship data
    @Override
    public String toString() {
        return "Ship{" + "id='" + id  + "name='" + name  + ", capacity ='" + capacity + ", current port='" + currentPort + '}';
    }

}
