package com.bismdhr.bankmgmtsystem.service;

import com.bismdhr.bankmgmtsystem.dto.UserUpdateDTO;
import com.bismdhr.bankmgmtsystem.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User findById(int id);

    User findByUsername(String username);

    User addUser(User user);

    User updateUser(UserUpdateDTO user);

    String deleteUser(int id);
}
