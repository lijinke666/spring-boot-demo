package com.example.demo.service;

import com.example.demo.modules.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getUser();
    Optional<User> getUserById(Integer userId);

    void deleteUser(Integer userId);
    User updateUser(User user);
    User createUser(User user);
}
