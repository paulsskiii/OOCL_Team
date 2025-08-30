package com.example.capstoneapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.capstoneapplication.model.Container;
import com.example.capstoneapplication.repository.ContainerRepository;

@Service
public class ContainerService {

    @Autowired
    private final ContainerRepository containerRepository;

    public ContainerService(ContainerRepository containerRepository) {
        this.containerRepository = containerRepository;
    }

    public List<Container> getAllContainer() {
        return containerRepository.findAll();
    }

    public Optional<Container> getContainerById(Long id) {
        return containerRepository.findById(id);
    }

    public Container addContainer(Container container) {
        return containerRepository.save(container);
    }

    public Container updateContainer(Container updatedContainer, Long id) {
        return containerRepository.findById(id)
            .map(container -> {
                container.setName(updatedContainer.getName());
                container.setOrigin(updatedContainer.getOrigin());
                container.setDestination(updatedContainer.getDestination());
                container.setStatus(updatedContainer.getStatus());
                container.setWeight(updatedContainer.getWeight());
                container.setDepartureDate(updatedContainer.getDepartureDate());
                container.setArrivalDate(updatedContainer.getArrivalDate());
                return containerRepository.save(container);
            })
            .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Container with id " + id + " not found"
            ));
    }

    public void deleteContainer(Long id) {
        if(!containerRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Container ID does not exists");
        }
        containerRepository.deleteById(id);
    }

    public List<Container> getContainersByDestinationAndArrivalDate(String destination, String arrivalDate) {
        return containerRepository.findByDestinationAndArrivalDate(destination, arrivalDate);
    }

}
