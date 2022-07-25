package com.bismdhr.bankmgmtsystem.service.impl;

import com.bismdhr.bankmgmtsystem.dto.UserUpdateDTO;
import com.bismdhr.bankmgmtsystem.exception.NotFoundException;
import com.bismdhr.bankmgmtsystem.model.User;
import com.bismdhr.bankmgmtsystem.repository.UserRepository;
import com.bismdhr.bankmgmtsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseThrow(() -> new NotFoundException("User not found for id :"+id));
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public User addUser(User user) {

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(UserUpdateDTO updateDTO) {
        User user = findById(updateDTO.getId());
        user.setFullName(updateDTO.getFullName());
        user.setAddress(updateDTO.getAddress());
        user.setGender(updateDTO.getGender());
        user.setAge(updateDTO.getAge());
        return userRepository.save(user);
    }

    @Override
    public String deleteUser(int id) {
       findById(id);
        userRepository.deleteById(id);
        return "User deleted successfully";
    }

}
