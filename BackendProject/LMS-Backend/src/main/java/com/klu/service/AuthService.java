package com.klu.service;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.klu.dto.LoginRequest;
import com.klu.dto.OtpRequest;
import com.klu.dto.RegisterRequest;
import com.klu.entity.Role;
import com.klu.entity.User;
import com.klu.repository.RoleRepo;
import com.klu.repository.UserRepo;

@Service
public class AuthService {

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;

   
    public String register(RegisterRequest request) throws Exception {

        String otp = String.valueOf((int)(Math.random() * 900000) + 100000); // ✅ 6 digit

        Role role = roleRepo.findByRoleName(request.getRoleName())
                .orElseThrow(() -> new RuntimeException("Role not found"));

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRoles(Set.of(role)); 
        user.setOtp(otp);
        user.setVerified(false);

        userRepo.save(user);

        emailService.sendOtp(user.getEmail(), otp);

        return "User registered. Check email for OTP.";
    }
    public String verifyOtp(OtpRequest request) {

        User user = userRepo.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getOtp() != null && user.getOtp().equals(request.getOtp())) {
            user.setVerified(true);
            user.setOtp(null);
            userRepo.save(user);
            return "Account verified ✅";
        }

        return "Invalid OTP ❌";
    }

   
   
       
      
        public String login(LoginRequest login1) {

            User user = userRepo.findByEmail(login1.getEmail())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            // ✅ Password check first
            if (!passwordEncoder.matches(login1.getPassword(), user.getPassword())) {
                throw new RuntimeException("Invalid credentials");
            }
            if (!user.isVerified()) {
                throw new RuntimeException("Please verify your email first");
            }

            boolean hasRole = user.getRoles().stream()
                    .anyMatch(r -> r.getRoleName().equals(login1.getRoleName()));

            if (!hasRole) {
                throw new RuntimeException("Invalid role selected");
            }

            return "Login successful ✅";
        }
}