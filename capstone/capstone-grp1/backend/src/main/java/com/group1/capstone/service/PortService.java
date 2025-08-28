package com.group1.capstone.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group1.capstone.exceptions.PortNotFoundException;
import com.group1.capstone.model.Port;
import com.group1.capstone.repository.PortRepository;

@Service
public class PortService {
    @Autowired
    private PortRepository portRepository;

    // 1. Find all ports
    public List<Port> getAllPorts() {
        return portRepository.findAll();
    }

    // 2. Find port by ID
    public Port getPortById(int id) {
        return portRepository.findById(id)
                .orElseThrow(() -> new PortNotFoundException("Port with ID " + id + " not found."));
    }

    // 3. Get port count
    public long getPortCount() {
        return portRepository.count();
    }

    // 4. Add port
    public Port addPort(Port port) {
        return portRepository.save(port);
    }

    // 5. Update port    
    public Port updatePort(int id, Port updatedPort) {
        return portRepository.findById(id).map(port -> {            
            port.setPortLocation(updatedPort.getPortLocation());
            port.setPortCode(updatedPort.getPortCode());
            port.setUpdatedAt(LocalDateTime.now());

            return portRepository.save(port);
        }).orElseThrow(() -> new PortNotFoundException("Port with ID " + id + " not found."));
    }
    
    // 6. Delete port
    public void deletePort(int id) {
        if (!portRepository.existsById(id)) {
            throw new PortNotFoundException("Port with ID " + id + " not found.");
        }
        portRepository.deleteById(id);
    }
}
