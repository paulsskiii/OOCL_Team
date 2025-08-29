package com.group1.capstone.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.group1.capstone.model.Role;
import com.group1.capstone.service.RoleService;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    // 1. Get all role
    @GetMapping
    public ResponseEntity<List<Role>> getAllRole() {
        return ResponseEntity.ok(roleService.getAllRoles());
    }

    // 2. Get role by ID
    @GetMapping("/{name}")
    public ResponseEntity<Role> getRoleById(@PathVariable String name) {
        return ResponseEntity.ok(roleService.getRoleById(name));
    }

    // 3. Get role count
    @GetMapping("/count")
    public ResponseEntity<Long> getRoleCount() {
        return ResponseEntity.ok(roleService.getRoleCount());
    }

    // 4. Add new role
    @PostMapping
    public ResponseEntity<Role> addRole(@RequestBody Role name) {
        return ResponseEntity.ok(roleService.addRole(name));
    }

    // 6. Delete role
    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteRole(@PathVariable String name) {
        roleService.deleteRole(name);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }
}
 