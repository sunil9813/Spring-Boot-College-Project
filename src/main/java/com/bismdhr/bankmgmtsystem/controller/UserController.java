package com.bismdhr.bankmgmtsystem.controller;

import com.bismdhr.bankmgmtsystem.dto.UserUpdateDTO;
import com.bismdhr.bankmgmtsystem.model.User;
import com.bismdhr.bankmgmtsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable int id){
        return userService.findById(id);
    }

    @PostMapping
    public User addUser( @RequestBody @Valid User user){
        return userService.addUser(user);
    }

    @PutMapping
    public ResponseEntity<User> updateUser (@RequestBody @Valid UserUpdateDTO user){
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id){
        return userService.deleteUser(id);
    }
 }
