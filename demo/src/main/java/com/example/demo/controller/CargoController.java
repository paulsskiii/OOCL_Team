// Controller
    //This is where we define our REST endpoints
    
// src/main/java/com/example/cargoservice/controller/CargoController.java
package com.example.demo.controller;

import com.example.demo.model.CargoItem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController // Marks this class as a REST Controller
@RequestMapping("/cargo") // Base path for all endpoints in this controller
public class CargoController {

    // In-memory "database" for demonstration purposes (will be replaced by JPA)
    private final List<CargoItem> cargoItems = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    // Initialize with some dummy data
    public CargoController() {
        cargoItems.add(new CargoItem(counter.incrementAndGet(), "Electronics", 150.0, "Manila", "Cebu"));
        cargoItems.add(new CargoItem(counter.incrementAndGet(), "Apparel", 50.5, "Davao", "Manila"));
        cargoItems.add(new CargoItem(counter.incrementAndGet(), "Perishables", 200.0, "Cebu", "Manila"));
    }

    /**
     * GET /cargo
     * Retrieves all cargo items.
     * @return List of CargoItem
     */
    @GetMapping // Maps HTTP GET requests to /cargo
    public ResponseEntity<List<CargoItem>> getAllCargoItems() {
        return ResponseEntity.ok(cargoItems); // Returns 200 OK with list of cargo items
    }

    /**
     * GET /cargo/{id}
     * Retrieves a single cargo item by its ID.
     * @param id The ID of the cargo item
     * @return CargoItem if found, or 404 Not Found
     */
    @GetMapping("/{id}") // Maps HTTP GET requests to /cargo/{id}
    public ResponseEntity<CargoItem> getCargoItemById(@PathVariable Long id) {
        Optional<CargoItem> cargoItem = cargoItems.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
        return cargoItem.map(ResponseEntity::ok) // If found, return 200 OK
                        .orElseGet(() -> ResponseEntity.notFound().build()); 
// Else, return 404 Not Found
    }

    /**
     * POST /cargo
     * Adds a new cargo item.
     * @param cargoItem The CargoItem object from the request body (JSON)
     * @return The created CargoItem with its generated ID, and 201 Created status
     */
    @PostMapping // Maps HTTP POST requests to /cargo
    public ResponseEntity<CargoItem> addCargoItem(@RequestBody CargoItem cargoItem) {
        cargoItem.setId(counter.incrementAndGet()); // Assign a new ID
        cargoItems.add(cargoItem); // Add to our in-memory list
        return new ResponseEntity<>(cargoItem, HttpStatus.CREATED); // Returns 201 Created status
    }
}