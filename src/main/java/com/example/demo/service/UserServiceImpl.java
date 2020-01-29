package com.example.demo.service;

import com.example.demo.modules.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired       // 依赖注入
    private UserRepository userRepository;

    @Override
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String userId) {
        return null;
    }

    @Override
    public void deleteUser(String userId) {

    }

    @Override
    public User updateUser(String userId) {
        return null;
    }
}
