package com.example.demo.controller;

import com.example.demo.modules.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Controller => Service (implement interface) => Repository

@RestController
public class UserController {
    @Autowired       // 依赖注入
    private UserServiceImpl userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUser();
    }
}
