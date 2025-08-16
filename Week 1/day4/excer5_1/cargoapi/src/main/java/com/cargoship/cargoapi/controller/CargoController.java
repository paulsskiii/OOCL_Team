package com.cargoship.cargoapi.controller;

import com.cargoship.cargoapi.model.CargoItem;
import com.cargoship.cargoapi.service.CargoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/cargo")
public class CargoController {

    private final List<CargoItem> cargoItems = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    // Constructor Injection for Cargo Service
    private final CargoService cargoService;

    // Initialize with some dummy data
    public CargoController(CargoService cargoService) {
        this.cargoService = cargoService;
    }


    /**
     * GET /cargo
     * Retrieves all cargo items.
     * @return List of CargoItem
     */
    @GetMapping // Maps HTTP GET requests to /cargo
    public ResponseEntity<List<CargoItem>> getAllCargoItems() {
//        return ResponseEntity.ok(cargoItems); // Returns 200 OK with list of cargo items
        return ResponseEntity.ok(cargoService.getAllCargoItems());
    }

    /**
     * GET /cargo/{id}
     * Retrieves a single cargo item by its ID.
     * @param id The ID of the cargo item
     * @return CargoItem if found, or 404 Not Found
     */
    @GetMapping("/{id}") // Maps HTTP GET requests to /cargo/{id}
    public ResponseEntity<CargoItem> getCargoItemById(@PathVariable Long id) {
        return cargoService.getCargoItemById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); //new using cargoService

    }

    /**
     * POST /cargo
     * Adds a new cargo item.
     * @param cargoItem The CargoItem object from the request body (JSON)
     * @return The created CargoItem with its generated ID, and 201 Created status
     */
    @PostMapping // Maps HTTP POST requests to /cargo
    public ResponseEntity<CargoItem> addCargoItem(@RequestBody CargoItem cargoItem) {
        CargoItem addCargo = cargoService.addCargoItem(cargoItem);
        return new ResponseEntity<>(addCargo, HttpStatus.CREATED); 
    }

    // PUT /cargo/{id}
    @PutMapping("/{id}")
    public ResponseEntity<CargoItem> updateCargoItem(@PathVariable Long id, @RequestBody CargoItem updatedCargoItem) {
        CargoItem updated = cargoService.updateCargoItem(id, updatedCargoItem);
        return (updated != null) ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    // DELETE /cargo/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCargoItem(@PathVariable Long id) {
        cargoService.deleteCargoItem(id);
        return ResponseEntity.noContent().build();
    }
}