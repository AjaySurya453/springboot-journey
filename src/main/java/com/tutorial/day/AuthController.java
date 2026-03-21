package com.tutorial.day;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Simple login — hardcoded user for now
    // Day 7+ we'll add real User entity + DB
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");

        // Hardcoded check for now
        if ("ajay".equals(username) && "password123".equals(password)) {
            String token = jwtUtil.generateToken(username);
            return Map.of(
                    "token", token,
                    "message", "Login successful!"
            );
        }
        throw new RuntimeException("Invalid credentials");
    }
}