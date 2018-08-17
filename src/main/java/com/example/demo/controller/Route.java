package com.example.demo.controller;

import com.example.demo.modules.UserModel;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class Route {

    @Autowired       //自动 new  帮你生成一个 实例
    private UserRepository userRepository;

    @RequestMapping(value = "/test" , method = GET)
    public Json test() {
        Json json = new Json();
        json.setName("test");
        return json;
    }

    @GetMapping("/users")
    public List<UserModel> index() {
        return userRepository.findAll();
    }
}
