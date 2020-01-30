package com.example.demo.service;

import com.example.demo.modules.User;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Page<User> getUsers(int page, int size);
    Optional<User> getUserById(Integer userId);

    void deleteUser(Integer userId);
    User updateUser(User user);
    User createUser(User user);
}
