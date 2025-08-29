package com.g3w4.container_management_system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g3w4.container_management_system.repository.PortsRepository;
import com.g3w4.container_management_system.model.Ports;

@Service
public class PortsService {
    @Autowired
    private final PortsRepository portsRepository;

    public PortsService(PortsRepository portsRepository){
        this.portsRepository = portsRepository;
    }

    public List<Ports> getAllPort(){
        return portsRepository.findAll();
    } 

    public Optional<Ports> getPortById(Integer id) {
        return portsRepository.findById(id); // Uses JpaRepository's findById()
    }

    public Ports addPort(Ports port) {
        return portsRepository.save(port); // Uses JpaRepository's save() for create/update
    }

    public void deletePort(Integer id) {
        portsRepository.deleteById(id); // Uses JpaRepository's deleteById()
    }
}
