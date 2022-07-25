package com.bismdhr.bankmgmtsystem.controller;

import com.bismdhr.bankmgmtsystem.model.Role;
import com.bismdhr.bankmgmtsystem.model.User;
import com.bismdhr.bankmgmtsystem.service.RoleService;
import com.bismdhr.bankmgmtsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolesController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<Role> getAll(){
        return roleService.getAllRoles();
    }
    @GetMapping("/{id}")
    public Role findById(@PathVariable int id){
        return roleService.findById(id);
    }

    @PostMapping
    public Role addRole(@RequestBody Role role){
        return roleService.addRole(role);
    }

    @PutMapping
    public Role updateRole(@RequestBody Role role){
        return roleService.updateRole(role);
    }

    @DeleteMapping("/{id}")
    public String deleteRole(@PathVariable int id){
        return roleService.deleteRole(id);
    }
}
