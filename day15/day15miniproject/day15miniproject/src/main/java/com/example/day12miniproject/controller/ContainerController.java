package com.example.day12miniproject.controller;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.day12miniproject.model.Container;
import com.example.day12miniproject.service.ContainerService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
        return containerService.getContainerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    
    @PostMapping
    public ResponseEntity<Container> addContainer(@RequestBody Container container) {
        String regex = "[^a-zA-Z0-9 ]"; 
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(container.getContainerName());
        if(matcher.find()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(containerService.addContainers(container));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContainer(@PathVariable Long id) {
        if (containerService.getContainerById(id).isPresent()) {
            containerService.deleteContainer(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    
    //  @PutMapping("/{id}")
    // public ResponseEntity<Container> updateContainer(@PathVariable Long id, @RequestBody Container containerDetails) {
    //     return ResponseEntity.ok(containerService.getContainerById(id))
    //             .map(container -> {
    //                 container.setContainerName(containerDetails.getContainerName());
    //                 container.setWeight(containerDetails.getWeight());
    //                 container.setOrigin(containerDetails.getOrigin());
    //                 container.setDestination(containerDetails.getOrigin());
    //                 return ResponseEntity.ok(containerService.updateContainer(container));
    //             }).orElse(ResponseEntity.notFound().build());
    // }


}
