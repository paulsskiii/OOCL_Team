package com.example.exercise2.cargo.service;

import com.example.exercise2.cargo.model.Container;
import com.example.exercise2.cargo.repository.ContainerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContainerService {

    @Autowired
    private ContainerRepository containerRepository;

    public List<Container> getAllContainers() {
        return containerRepository.findAll();
    }

    public Container getContainerById(Long id) {
        return containerRepository.findById(id).orElse(null);
    }

    public Container addContainer(Container container) {
        return containerRepository.save(container);
    }

    public Container updateContainer(Long id, Container updatedContainer) {
        Container foundContainer = containerRepository.findById(id).orElse(null);
        if (foundContainer != null) {
            foundContainer.setName(updatedContainer.getName());
            foundContainer.setWeight(updatedContainer.getWeight());
            foundContainer.setOrigin(updatedContainer.getOrigin());
            foundContainer.setDestination(foundContainer.getDestination());
            return containerRepository.save(foundContainer);
        }
        return null;
    }


    public boolean deleteContainer(Long id) {
        Container foundContainer = containerRepository.findById(id).orElse(null);
        if (foundContainer != null) {
            containerRepository.delete(foundContainer);
            System.out.println("Container with ID " + id +" was deleted");
            return true;
        } else {
            System.out.println("Container with ID " + id + " not found for deletion. ");
            return false;
        }
    }

    public List<Container> searchContainerByOrigin(String origin) {
        return containerRepository.findByOrigin(origin);
    }

    public List<Container> searchContainerByDestination(String destination) {
        return containerRepository.findByDestination(destination);
    }

    public List<Container> searchContainerByWeightRange(double minWeight, double maxWeight) {
        return containerRepository.findByWeightBetween(minWeight, maxWeight);
    }

    public List<Container> searchContainerByOriginPattern(String originPattern) {
        return containerRepository.findByOriginContaining(originPattern);
    }

    public List<Container> searchContainerByName(String name) {
        return containerRepository.findByName(name);
    }
}