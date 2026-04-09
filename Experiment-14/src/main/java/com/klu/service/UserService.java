package com.klu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.model.User;
import com.klu.Repo.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo ur;

    // ✅ Register
    public User register(User user) {
        if (ur.existsByGmail(user.getGmail())) {
            throw new RuntimeException("Email already registered!");
        }
        return ur.save(user); // save single user
    }

    // ✅ Login
    public User login(String gmail, String password) {
        User user = ur.findByGmailAndPassword(gmail, password);
        if (user == null) {
            throw new RuntimeException("Invalid email or password!");
        }
        return user;
    }

    // ✅ Get User by ID
    public User getUserById(Long id) {
        return ur.findById(id)
                 .orElseThrow(() -> new RuntimeException("User not found!"));
    }
}