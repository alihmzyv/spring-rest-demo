package com.example.springrestdemo.rest.controller;

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
}
