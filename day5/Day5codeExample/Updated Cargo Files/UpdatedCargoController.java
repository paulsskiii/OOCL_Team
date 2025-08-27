// Update CargoController.java to use Cargo Service
    //The controller now delegates to the CargoService for all data operations.

// src/main/java/com/example/cargoservice/controller/CargoController.java
package com.example.cargoservice.controller;

import com.example.cargoservice.model.CargoItem;
import com.example.cargoservice.service.CargoService; // Import CargoService
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cargo")
public class CargoController {

    private final CargoService cargoService; // Inject CargoService

    // Constructor injection for dependency
    public CargoController(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    @GetMapping
    public ResponseEntity<List<CargoItem>> getAllCargoItems() {
        return ResponseEntity.ok(cargoService.getAllCargoItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CargoItem> getCargoItemById(@PathVariable Long id) {
        Optional<CargoItem> cargoItem = cargoService.getCargoItemById(id);
        return cargoItem.map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CargoItem> addCargoItem(@RequestBody CargoItem cargoItem) {
        CargoItem newCargo = cargoService.addCargoItem(cargoItem);
        return new ResponseEntity<>(newCargo, HttpStatus.CREATED);
    }

    // Add PUT and DELETE methods later in exercises
}
