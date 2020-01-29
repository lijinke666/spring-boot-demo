package com.example.demo.service;

import com.example.demo.modules.User;

import java.util.List;

public interface UserService {
    List<User> getUser();
    User getUserById(String userId);

    void deleteUser(String userId);
    User updateUser(String userId);
}
