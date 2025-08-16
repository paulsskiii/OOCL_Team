package com.example.cargoservice.controller;

import com.example.cargoservice.model.CargoItem;
import com.example.cargoservice.service.CargoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cargo")
public class CargoController {

    private final CargoService cargoService;

    public CargoController(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    // Exercise 1.1, 1.2, 1.4, 1.5, 1.6 integrated here
    @GetMapping
    public ResponseEntity<List<CargoItem>> getAllCargoItems(
            @RequestParam(required = false) String origin,
            @RequestParam(required = false) String destination,
            @RequestParam(required = false) Double minWeight,
            @RequestParam(required = false) Double maxWeight,
            @RequestParam(required = false) String originPattern,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id,asc") String[] sort) {

        if (origin != null) {
            return ResponseEntity.ok(cargoService.searchCargoByOrigin(origin));
        }
        if (destination != null) {
            return ResponseEntity.ok(cargoService.searchCargoByDestination(destination));
        }
        if (minWeight != null && maxWeight != null) {
            return ResponseEntity.ok(cargoService.searchCargoByWeightRange(minWeight, maxWeight));
        }
        if (originPattern != null) {
            return ResponseEntity.ok(cargoService.searchCargoByOriginPattern(originPattern));
        }

        // Handle pagination and sorting
        Sort sortOrder = Sort.by(sort[0].split(",")[0]);
        if (sort.length > 1 && sort[0].split(",").length > 1) {
            sortOrder = sort[0].split(",")[1].equalsIgnoreCase("desc") ?
                    sortOrder.descending() : sortOrder.ascending();
        }

        Page<CargoItem> cargoPage = cargoService.getAllCargoItems(PageRequest.of(page, size, sortOrder));
        System.out.println (cargoService.getShippingFee ());
        return ResponseEntity.ok(cargoPage.getContent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CargoItem> getCargoItemById(@PathVariable Long id) {
        return ResponseEntity.ok(cargoService.getCargoItemById(id));
    }

    @PostMapping
    public ResponseEntity<CargoItem> addCargoItem(@RequestBody CargoItem cargoItem) {
        CargoItem newCargo = cargoService.addCargoItem(cargoItem);
        return new ResponseEntity<>(newCargo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CargoItem> updateCargoItem(@PathVariable Long id, @RequestBody CargoItem cargoItem) {
        CargoItem updatedCargo = cargoService.updateCargoItem(id, cargoItem);
        return ResponseEntity.ok(updatedCargo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCargoItem(@PathVariable Long id) {
        cargoService.deleteCargoItem(id);
    }
}
