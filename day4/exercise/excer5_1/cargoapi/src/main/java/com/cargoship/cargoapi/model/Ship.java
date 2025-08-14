package com.cargoship.cargoapi.model;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * A basic model class for a Ship.
 */
public class Ship {
    //  Declare private fields (id, name, capacity, currentPort)
    private int id;
    private String name;
    private int capacity;
    private String currentPort;
    //  Add default constructor
        @Autowired
        public Ship (int id,String name,int capacity,String currentPort) {
            this.id = id;
            this.name = name;
            this.capacity = capacity;
            this.currentPort = currentPort;
    }

    
    //  Add constructor with all fi
        
    //  Add getters and set
    //  Override toString() to return formatted ship data
    @Override
    public String toString () {
        return ("ID: " + this.id + ", Name: " + this.name + ", Capacity: " + this.capacity + ", Current Port: ");
    }
    
}
