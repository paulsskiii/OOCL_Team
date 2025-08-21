package com.cargoship.cargoapi.model;

/**
 * A basic model class for a Ship.
 */
public class Ship {
    // TODO: Declare private fields (id, name, capacity, currentPort)
    private int id;
    private String name;
    private int capacity;
    private String currentPort;

    // TODO: Add default constructor
    public Ship(){
    }

    // TODO: Add constructor with all fields
    public Ship(int id, String name, int capacity, String currentPort){
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.currentPort = currentPort;
    }

    // TODO: Add getters and setters
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getCapacity(){
        return capacity;
    }
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

    public String getCurrentPort(){
        return currentPort;
    }
    public void setCurrentPort(String currentPort){
        this.id = id;
    }
    
    // TODO: Override toString() to return formatted ship data
    @Override
    public String toString(){
        return "ID:" + getId() + " name:" + getName() + " capacity:" + getCapacity() + " current port:" + getCurrentPort();
    }
}
