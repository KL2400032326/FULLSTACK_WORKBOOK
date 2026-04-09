package com.klu.service;                                                                                                                                                                    
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.klu.dto.LoginRequest;
import com.klu.dto.OtpRequest;
import com.klu.dto.RegisterRequest;
import com.klu.entity.User;
import com.klu.repository.UserRepo;

@Service
public class AuthService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;

    // REGISTER
    public String register(RegisterRequest request) throws Exception {

        String otp = String.valueOf((int)(Math.random() * 9000) + 1000);

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setOtp(otp);
        user.setVerified(false);

        userRepo.save(user);

        emailService.sendOtp(user.getEmail(), otp);

        return "User registered. Check email for OTP.";
    }

    // VERIFY OTP
    public String verifyOtp(OtpRequest request) {
        User user = userRepo.findByEmail(request.getEmail())
                .orElseThrow();

        if (user.getOtp().equals(request.getOtp())) {
            user.setVerified(true);
            user.setOtp(null);
            userRepo.save(user);
            return "Account verified!";
        }

        return "Invalid OTP";
    }

    // LOGIN
    public String login(LoginRequest request) {
        User user = userRepo.findByEmail(request.getEmail())
                .orElseThrow();

        if (!user.isVerified()) {
            return "Verify your account first!";
        }

        if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return "Login successful!";
        }

        return "Invalid credentials";
    }
}