package com.g3w4.container_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g3w4.container_management_system.model.Ports;

@Repository
public interface PortsRepository extends JpaRepository<Ports, Integer> {

}