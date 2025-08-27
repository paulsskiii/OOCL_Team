package com.example.exercise2.cargo.controller;


import com.example.exercise2.cargo.model.Container;
import com.example.exercise2.cargo.service.ContainerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/container")
public class ContainerController {

    @Autowired
    private ContainerService containerService;

    @GetMapping("/{id}")
    public ResponseEntity<Container> findContainerById(@PathVariable Long id) {
        Container container = containerService.getContainerById(id);
        return container == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(container, HttpStatus.OK) ;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Container>> findAllContainers() {
        List<Container> containerList = containerService.getAllContainers();
        return new ResponseEntity<>(containerList, HttpStatus.OK);
    }

    @PostMapping("/create_container")
    public ResponseEntity<Container> createContainer(@RequestBody Container container) {
        Container newContainer = containerService.addContainer(container);
        return new ResponseEntity<>(newContainer, HttpStatus.CREATED);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Container> updateContainer(@PathVariable Long id, @RequestBody Container container) {
        return new ResponseEntity<>(containerService.updateContainer(id, container), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteContainer(@PathVariable Long id) {
        return containerService.deleteContainer(id) ?
            new ResponseEntity<>("Container is successfully deleted", HttpStatus.OK) : new ResponseEntity<>("Container not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Container>> searchByName(@RequestParam(name="name") String name) {
        List<Container> results = containerService.searchContainerByName(name);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }
}
