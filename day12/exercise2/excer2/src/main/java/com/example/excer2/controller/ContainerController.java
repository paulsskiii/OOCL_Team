package com.example.excer2.controller;

import com.example.excer2.model.Container;
import com.example.excer2.service.ContainerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/container")
public class ContainerController {

    private final ContainerService containerService;

    public ContainerController(ContainerService containerService) {
        this.containerService = containerService;
    }

    @GetMapping
    public ResponseEntity<List<Container>> getAllContainers() {
        return ResponseEntity.ok(containerService.getAllContainers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Container> getContainerById(@PathVariable Long id) {
        List <Container> containerItems = containerService.getAllContainers();
        Optional<Container> container = containerItems.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
        return container.map(ResponseEntity::ok) // If found, return 200 OK
                        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Container> addContainer(@RequestBody Container container) {
        Container newContainer = containerService.addContainer(container);
        return new ResponseEntity<>(newContainer, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Container> updateContainer(@PathVariable Long id, @RequestBody Container container) {
        container.setId(id);
        Container updatedContainer = containerService.updateContainer(container);
        return ResponseEntity.ok(updatedContainer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContainer(@PathVariable Long id) {
        containerService.deleteContainer(id);
    }
}
