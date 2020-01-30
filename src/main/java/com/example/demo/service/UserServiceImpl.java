package com.example.demo.service;

import com.example.demo.modules.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired       // 依赖注入
    private UserRepository userRepository;

    @Override
    public Page<User> getUsers(int page, int size) {
        // Sort.by("id") 排序
        // 排序方式 Sort.Direction.ASC
        Pageable pageable = PageRequest.of(page - 1, size, Sort.by("id"));
        // 获取分页的内容 userPage.getContent()
        return userRepository.findAll(pageable);
    }

    @Override
    public Optional<User> getUserById(Integer userId) {
        return userRepository.findById(userId);
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
