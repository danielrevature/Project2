package com.revature.developercorner.controller;

import com.revature.developercorner.entity.Role;
import com.revature.developercorner.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// RoleController Class
// This class will handle the HTTP Requests for the API/resource paths associated with the Role objects.
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class RoleController {

    @Autowired
    RoleService roleService;

    // PostMapping to add a Role to the database:
    @PostMapping("/roles")
    public void addRole(@RequestBody Role role) {
        roleService.addRole(role);
    }

    // GetMapping to retrieve a specific Role object from the database:
    @GetMapping("/roles/{id}")
    public Role getRoleById(@PathVariable("id") Long id) {
        return roleService.getRoleById(id);
    }

    // GetMapping to retrieve Role objects from the database:
    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    // PutMapping to update a specified Role with the supplied JSON Role object in the database:
    @PutMapping("/roles/{id}")
    public void updateRoles(@PathVariable("id") Long id, @RequestBody Role role) {
        roleService.updateRole(id, role);
    }

    // DeleteMapping to delete a specified Role record from the database:
    @DeleteMapping("/roles/{id}")
    public void deleteRole(@PathVariable("id") Long id) {
        roleService.deleteRole(id);
    }
}
