package com.github.throyer.cars.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public Map<String, ?> index() {
        return Map.of("message", "hello");
    }
}
