/**
 * A basic model class for a Ship.
 */

package com.cargoship.cargoapi.model;

public class Ship {
    // TODO: Declare private fields (id, name, capacity, currentPort)
    int id;
    String name;
    double capacity;
    String currentPort;
    // TODO: Add default constructor

    public Ship(){
    }
    // TODO: Add constructor with all fields

    public Ship(int id, String name, double capacity, String currentPort){
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.currentPort = currentPort;
    }
    // TODO: Add getters and setters
    public void setId(int id){
        this.id = id;
    }
    
    public void setName(String name){
       this.name = name;
    }

    public void setCapacity(double capacity){
        this.capacity = capacity;
    }

    public void setCurrentPort(String currentPort){
        this.currentPort = currentPort;
    }

    public int getId(){
        return this.id;
    }
    
    public String getName(){
        return this.name;
    }

    public double getCapacity(){
        return this.id;
    }

    public String getCurrentPort(){
        return this.currentPort;
    }
    
    // TODO: Override toString() to return formatted ship data
    @Override
    public String toString(){
        return this.id + " " + this.name + " " + this.capacity + " " + this.currentPort;
    }
}
