package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.klu.dto.LoginRequest;
import com.klu.dto.OtpRequest;
import com.klu.dto.RegisterRequest;
import com.klu.service.AuthService;
@CrossOrigin(origins = "http://localhost:5174")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) throws Exception {
        return authService.register(request);
    }
    @PostMapping("/verify")
    public String verify(@RequestBody OtpRequest request) {
        return authService.verifyOtp(request);
    }
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest
        request) {
        return authService.login(request);
    }
}