package com.example.demo.controller;

import com.example.demo.modules.User;
import com.example.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.Optional;

// Controller => Service (implement interface) => Repository

@RestController
public class UserController {
    @Autowired       // 依赖注入
    private UserServiceImpl userService;

    @GetMapping("/users")
    public Page<User> getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                               @RequestParam(value = "size", defaultValue = "5") int size
            ) {

        return userService.getUsers(page, size);
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    @ResponseStatus(code = HttpStatus.CREATED)
    public User createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/users")
    public User updateUser(@Valid @RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
    
    @PostMapping("/users/upload")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public String upload(@RequestParam("file")  MultipartFile file) {
        System.out.println(file);
        if(file.isEmpty()) {
            throw new HTTPException(400);
        }
        String contentType = file.getContentType();
        String originalFilename = file.getOriginalFilename();
        long size = file.getSize();
        System.out.println(String.format("文件上传：类型:%s, 名称：%s, 大小: %s",contentType, originalFilename,size));
        return "上传成功";
    }
}
