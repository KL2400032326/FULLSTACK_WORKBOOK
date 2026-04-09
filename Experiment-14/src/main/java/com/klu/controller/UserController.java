package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.model.User;
import com.klu.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5174") // React URL
public class UserController {

    @Autowired
    private UserService us;

    // ✅ LOGIN API
    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return us.login(user.getGmail(), user.getPassword());
    }

    // ✅ REGISTER API
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return us.register(user);
    }

    // ✅ GET USER PROFILE
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {
        return us.getUserById(id);
    }
}