package com.example.capstoneapplication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.capstoneapplication.model.Container;
import com.example.capstoneapplication.service.ContainerService;


@RestController
@RequestMapping("/api/container")
@CrossOrigin(origins = "http://localhost:3000")
public class ContainerController {


    private final ContainerService containerService;

    public ContainerController(ContainerService containerService){
        this.containerService = containerService;
    }

    @GetMapping
    public ResponseEntity<List<Container>> getAllContainer() {
        return ResponseEntity.ok(containerService.getAllContainer());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Container> getContainerById(@PathVariable Long id) {
        Optional<Container> container = containerService.getContainerById(id);
        return container.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Container> addContainer(@RequestBody Container container) {
        return ResponseEntity.ok(containerService.addContainer(container)); // update ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Container> updateContainer(@RequestBody Container container, @PathVariable Long id) {
        return ResponseEntity.ok(containerService.updateContainer(container, id));
    }

    @DeleteMapping("/{id}")
    public void deleteContainer(@PathVariable Long id) {
        containerService.deleteContainer(id); // updated return ResponseEntity.noContent().build();
    }

    @GetMapping("/filter/destination")
    public ResponseEntity<List<Container>> filterContainers(
            @RequestParam String destination,
            @RequestParam String arrivalDate) {
        return ResponseEntity.ok(containerService.getContainersByDestinationAndArrivalDate(destination, arrivalDate));
    }

}
