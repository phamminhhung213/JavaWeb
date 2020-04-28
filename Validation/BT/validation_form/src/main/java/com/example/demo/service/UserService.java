package com.example.demo.service;


import com.example.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UserService {
    Page<User> findAll (Pageable pageable);

    User findById(String id);

    void save(User user);

    void remove(String id);
}