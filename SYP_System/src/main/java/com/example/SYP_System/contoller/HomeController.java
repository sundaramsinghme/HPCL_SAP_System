package com.example.SYP_System.contoller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@CrossOrigin(origins = { "http://localhost:5173", "http://localhost:5174", "https://hpclsparesportal.in" })
public class HomeController {

    @GetMapping("/")
    public String Home() {
        return "Server Started";
    }
}
