package com.vazquez.capstone.userservice.service;

import com.vazquez.capstone.userservice.model.User;
import com.vazquez.capstone.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(String username, String password, String bio) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password); 
        user.setBio(bio);
        return userRepository.save(user);
    }

    public User findUserByUsername(String username) {


        return userRepository.findByUsername(username);
    }

    public User updateUser(String username, String bio) 
    {
        User user = findUserByUsername(username);
        if (user != null) {
            user.setBio(bio);
            return userRepository.save(user);
        }
        return null; // user was not found
    }

    public boolean deleteUser(String username) {
        User user = findUserByUsername(username);
        if (user != null) {
            userRepository.delete(user);
            return true; // user was deleted successfully
        }
        return false; // user was not found
    }





    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}