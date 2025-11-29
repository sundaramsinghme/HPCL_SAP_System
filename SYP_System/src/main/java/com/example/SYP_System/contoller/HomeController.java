package com.example.SYP_System.contoller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HomeController {
    
    @GetMapping("/")
    public String Home() {
        return "Server Started";
    }
}
