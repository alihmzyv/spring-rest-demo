package com.example.springrestdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class HelloWorldController {
    @GetMapping("/hello")
    public String greet() {
        return "Hello World !";
    }

    @GetMapping("hello/1")
    public List<String> greetThemAll() {
        return List.of("Hello", "Hello");
    }
}
