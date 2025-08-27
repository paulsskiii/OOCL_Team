package com.example.excer1.service;

import java.util.List;
import java.util.Optional;

import com.example.excer1.ContainerProducer;
import com.example.excer1.model.Container;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.excer1.exception.SameOriginDestinationException;

import com.example.excer1.repository.ContainerRepository;

@Service
public class ContainerService {

    @Autowired
    private ContainerRepository containerRepository;
    @Autowired
    private ContainerProducer containerProducer;

    public List<Container> getAllContainers() {
        return containerRepository.findAll();
    }

    public Optional<List<Container>> getContainerById(String id) {
        return containerRepository.findByContainerNumber(id); // Uses JpaRepository's findById()
    }

    public Optional<List<Container>> getContainerByOrigin(String origin) {
        return containerRepository.findByOrigin(origin);
    }

    public Optional<List<Container>> getContainerByDestination(String destination) {
        return containerRepository.findByDestination(destination);
    }

    public Container addContainer(Container container) throws NullPointerException, SameOriginDestinationException {
        containerProducer.sendMessage("AddContainer", container);

        if (container.getContainerNumber() == null) {
            throw new NullPointerException("Container Number is null");
        }
        if (container.getOrigin() == null) {
            throw new NullPointerException("Origin is null");
        }
        if (container.getDestination() == null) {
            throw new NullPointerException("Destination is null");
        }
        if (container.getOrigin() == container.getDestination()) {
            throw new SameOriginDestinationException("Origin and Destination should not be the same");
        }
        return containerRepository.save(container); // Uses JpaRepository's save() for create/update
    }

    public Container updateContainer(Container container) {
        containerProducer.sendMessage("UpdateContainer", container);
        return containerRepository.save(container);
    }

    public void deleteContainer(Container container) {
        containerProducer.sendMessage("DeleteContainer", container);
        containerRepository.deleteById(container.getContainerNumber());
    }

}
