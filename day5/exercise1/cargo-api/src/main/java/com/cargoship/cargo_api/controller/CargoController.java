package com.cargoship.cargo_api.controller;

import com.cargoship.cargo_api.model.CargoItem;
import com.cargoship.cargo_api.service.CargoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/cargo")
@AllArgsConstructor
@RestController
public class CargoController {

    @Autowired
    private final CargoService cargoService;

    @GetMapping ("/allCargo")
    public ResponseEntity<List<CargoItem>> getAllCargoItems() {
        return ResponseEntity.ok(cargoService.getAllCargoItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CargoItem> getCargoItemById(@PathVariable Long id) {
        CargoItem cargoItem = cargoService.getCargoItemById(id);
        if (cargoItem != null) {
            return ResponseEntity.ok(cargoItem);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/addCargo")
    public ResponseEntity<CargoItem> addCargoItem(@RequestBody CargoItem cargoItem) {
        return ResponseEntity.ok(cargoService.saveCargoItem(cargoItem)); // Returns 201 Created status
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CargoItem> updateCargoItem(@PathVariable Long id, @RequestBody CargoItem cargoItem) {
        return ResponseEntity.ok(cargoService.updateCargoItem(id, cargoItem));
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<CargoItem> deleteCargoItem(@PathVariable Long id) {
        cargoService.deleteCargoItem(id);
        return ResponseEntity.ok().build();
    }
}
