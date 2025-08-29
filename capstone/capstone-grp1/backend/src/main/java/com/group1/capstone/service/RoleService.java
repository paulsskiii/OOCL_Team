package com.group1.capstone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group1.capstone.exceptions.RoleNotFoundException;
import com.group1.capstone.model.Role;
import com.group1.capstone.repository.RoleRepository;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    // 1. Find all ports
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    // 2. Find port by ID
    public Role getRoleById(String name) {
        return roleRepository.findById(name)
                .orElseThrow(() -> new RoleNotFoundException("Role " + name + " not found."));
    }

    // 3. Get port count
    public long getRoleCount() {
        return roleRepository.count();
    }

    // 4. Add port
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }
    
    // 6. Delete port
    public void deleteRole(String name) {
        if (!roleRepository.existsById(name)) {
            throw new RoleNotFoundException("Role  " + name + " not found.");
        }
        roleRepository.deleteById(name);
    }
}
