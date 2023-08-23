package com.example.springhibernateproject.controller;

import com.example.springhibernateproject.dao.UserDAO;
import com.example.springhibernateproject.entities.User;
import com.example.springhibernateproject.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private UserRepository userRepository;

    private UserDAO dao;

    private UserController (UserRepository userRepository, UserDAO dao){
        this.userRepository = userRepository;
        this.dao = dao;
    }

    @GetMapping("/api/users")
    private List<User> findAllUsers() {
        return this.userRepository.findAll();
    }

    @GetMapping("/api/users/active")
    private List<User> findAllActive() {
        return this.dao.findAllActive();
    }

    @PostMapping("/api/user")
    private User createUser(@RequestBody User user){
        return this.userRepository.save(user);
    }



}