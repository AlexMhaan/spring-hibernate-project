package com.example.springhibernateproject;

import com.example.springhibernateproject.entities.User;
import com.example.springhibernateproject.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private UserRepository userRepository;

    private UserController (UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/api/users")
    private List<User> findAllUsers() {

        return this.userRepository.findAll();

    }
}