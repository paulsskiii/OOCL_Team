package com.group1.capstone.controller;

import com.group1.capstone.exceptions.SameOriginDestinationException;
import com.group1.capstone.model.Container;
import com.group1.capstone.service.ContainerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/containers")
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
    public ResponseEntity<Container> getContainerById(@PathVariable String id) {
        List<Container> containerItems = containerService.getAllContainers();
        Optional<Container> container = containerItems.stream()
                .filter(c -> c.getContainerNumber().equals(id))
                .findFirst();
        return container.map(ResponseEntity::ok) // If found, return 200 OK
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Container> addContainer(@RequestBody Container container) throws NullPointerException, SameOriginDestinationException {
        Container newContainer = containerService.addContainer(container);
        return new ResponseEntity<>(newContainer, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Container> updateContainer(@PathVariable String id, @RequestBody Container container) {
        container.setContainerNumber(id);
        Container updatedContainer = containerService.updateContainer(container);
        return ResponseEntity.ok(updatedContainer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContainer(@PathVariable String id, @RequestBody Container container) {
        containerService.deleteContainer(container);
    }
}
