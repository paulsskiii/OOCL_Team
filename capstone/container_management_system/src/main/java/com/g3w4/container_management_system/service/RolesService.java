package com.g3w4.container_management_system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g3w4.container_management_system.repository.RolesRepository;
import com.g3w4.container_management_system.model.Roles;

@Service
public class RolesService {
    @Autowired
    private final RolesRepository rolesRepository;

    public RolesService(RolesRepository rolesRepository){
        this.rolesRepository = rolesRepository;
    }

    public List<Roles> getAllRoles(){
        return rolesRepository.findAll();
    } 

    public Optional<Roles> getRolesById(Integer id) {
        return rolesRepository.findById(id); // Uses JpaRepository's findById()
    }

    public Roles addRoles(Roles roles) {
        return rolesRepository.save(roles); // Uses JpaRepository's save() for create/update
    }

    public void deleteRoles(Integer id) {
        rolesRepository.deleteById(id); // Uses JpaRepository's deleteById()
    }



}
