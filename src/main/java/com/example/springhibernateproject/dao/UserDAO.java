package com.example.springhibernateproject.dao;

import com.example.springhibernateproject.entities.User;

import java.util.List;


public interface UserDAO {

    List<User> findAllActive();

}
