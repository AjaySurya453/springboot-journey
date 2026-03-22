package com.tutorial.day;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // REGISTER — create new user
    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(
            @Valid @RequestBody User user) {

        // Check if username already exists
        if (userRepository.findByUsername(
                user.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body(
                    Map.of("message", "Username already exists!"));
        }

        // Hash password before saving — NEVER save plain text
        user.setPassword(
                passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);

        return ResponseEntity.ok(
                Map.of("message", "User registered successfully!"));
    }

    // LOGIN — returns JWT token
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(
            @RequestBody Map<String, String> request) {
        try {
            // Spring Security verifies username + password
            authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.get("username"),
                            request.get("password")
                    )
            );

            // If we reach here — credentials are valid!
            String token = jwtUtil.generateToken(
                    request.get("username"));

            return ResponseEntity.ok(Map.of(
                    "token", token,
                    "message", "Login successful!"
            ));

        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body(
                    Map.of("message", "Invalid username or password"));
        }
    }
}