package com.example.demo.controller;

import com.example.demo.modules.UserModel;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired       // 依赖注入
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<UserModel> getUsers() {
        return userRepository.findAll();
    }
}
