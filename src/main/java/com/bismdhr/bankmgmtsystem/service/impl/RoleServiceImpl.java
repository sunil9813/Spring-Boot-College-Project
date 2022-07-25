package com.bismdhr.bankmgmtsystem.service.impl;

import com.bismdhr.bankmgmtsystem.exception.NotFoundException;
import com.bismdhr.bankmgmtsystem.model.Role;
import com.bismdhr.bankmgmtsystem.model.User;
import com.bismdhr.bankmgmtsystem.repository.RoleRepository;
import com.bismdhr.bankmgmtsystem.repository.UserRepository;
import com.bismdhr.bankmgmtsystem.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(int id) {
        Optional<Role> optionalRole = roleRepository.findById(id);
        return optionalRole.orElseThrow(() -> new NotFoundException("Role not found for id :"+id));
    }

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role updateRole(Role role) {
        findById(role.getId());
        return roleRepository.save(role);
    }

    @Override
    public String deleteRole(int id) {
        findById(id);
        roleRepository.deleteById(id);
        return "Role deleted successfully";
    }

}
