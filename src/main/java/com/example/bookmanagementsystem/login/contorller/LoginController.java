package com.example.bookmanagementsystem.login.contorller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class LoginController {

    @GetMapping("/login")
    public String login() {
    return "login";
    }

    @PostMapping
    public String loginUser() {

        return "login";
    }

}
