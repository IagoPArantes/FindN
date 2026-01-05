package com.find.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login() {
        return "login"; // SEM .html e SEM redirect
    }

    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastro";
    }
}
