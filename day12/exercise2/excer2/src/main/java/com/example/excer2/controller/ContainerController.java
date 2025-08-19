package com.example.excer2.controller;

import com.example.excer2.model.Container;
import com.example.excer2.service.ContainerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/container")
public class ContainerController {

    private final ContainerService containerService;

    public ContainerController(ContainerService containerService) {
        this.containerService = containerService;
    }

    @GetMapping
    public ResponseEntity<List<ContainerItem>> getAllContainerItems(
            @RequestParam(required = false) String size,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Double weight,
            @RequestParam(required = false) String contentDescription) {
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContainerItem> getContainerItemById(@PathVariable Long id) {
        return ResponseEntity.ok(containerService.getContainerItemById(id));
    }

    @PostMapping
    public ResponseEntity<ContainerItem> addContainerItem(@RequestBody ContainerItem containerItem) {
        ContainerItem newContainer = containerService.addContainerItem(containerItem);
        return new ResponseEntity<>(newContainer, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContainerItem> updateContainerItem(@PathVariable Long id, @RequestBody ContainerItem containerItem) {
        ContainerItem updatedContainer = containerService.updateContainerItem(id, containerItem);
        return ResponseEntity.ok(updatedContainer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContainerItem(@PathVariable Long id) {
        containerService.deleteContainerItem(id);
    }
}
