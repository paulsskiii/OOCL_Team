package com.cargoship.cargo_api.model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ShipRepository{

    private final List<Ship> ships = new ArrayList<>();

    public ShipRepository(){
        this.ships.add(new Ship(1,"OOCU1234", 23, "Japan"));
        this.ships.add(new Ship(2,"OOCU1234", 23, "America"));
        this.ships.add(new Ship(3,"OOCU1234", 23, "China"));
    }

    public List<Ship> findAllShips(){
        return this.ships;
    };

    public Optional<Ship> findShipById(int id){
        return this.ships.stream()
                .filter(ship -> ship.getId() == id)
                .findFirst();
    }
}
