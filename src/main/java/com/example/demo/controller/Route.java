package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class Route {
    @RequestMapping(value = "/test" , method = GET)
    public Json test() {
        Json json = new Json();
        json.setName("test");
        return json;
    }
}
