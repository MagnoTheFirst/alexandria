package com.example.alexandria.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${spring.application.name}")
    String appName;


    @GetMapping("/")
    public String getAppName(){
        return this.appName;
    }
}
