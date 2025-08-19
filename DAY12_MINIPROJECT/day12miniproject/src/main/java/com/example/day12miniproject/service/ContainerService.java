package com.example.day12miniproject.service;

import java.util.List;
import java.util.Optional;

import com.example.day12miniproject.model.Container;
import com.example.day12miniproject.repository.ContainerRepository;

public class ContainerService {

    private final  ContainerRepository containerRepository;

      public ContainerService(ContainerRepository containerRepository) {
        this.containerRepository = containerRepository;
    }

    public List<Container> getAllContainer() {
        return containerRepository.findAll(); // Uses JpaRepository's findAll()
    }

    public Optional<Container> getContainerById(Long id) {
        return containerRepository.findById(id); // Uses JpaRepository's findById()
    }

    public Container addContainers(Container container) {
        return containerRepository.save(container); // Uses JpaRepository's save() for create/update
    }

    public void deleteContainer(Long id) {
        containerRepository.deleteById(id); // Uses JpaRepository's deleteById()
    }
    
    public Long countbyDestination (Long id, String destination) {
        List<Container> containerList = containerRepository.findAll();

        return containerList.stream()
            .filter(container -> container.getDestination().toUpperCase() == destination.toUpperCase())
            .count();
    }

    public Long countbyOrigin (Long id, String origin) {
        List<Container> containerList = containerRepository.findAll();

        return containerList.stream()
            .filter(container -> container.getOrigin().toUpperCase() == origin.toUpperCase())
            .count();
    }
}
