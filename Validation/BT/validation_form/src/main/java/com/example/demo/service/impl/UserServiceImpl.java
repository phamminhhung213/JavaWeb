package com.example.demo.service.impl;


import com.example.demo.model.User;
import com.example.demo.reponsitory.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;



    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id).orElse(null);
    }


    @Override
    public void save(User user) {
        userRepository.save(user);

    }

    @Override
    public void remove(String id) {
        userRepository.deleteById(id);
    }
}
