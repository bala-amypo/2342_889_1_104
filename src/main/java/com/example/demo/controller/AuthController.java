package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.model.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.security.JwtTokenProvider;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountRepository userAccountRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    // ✅ Constructor Injection (VERY IMPORTANT)
    public AuthController(UserAccountRepository userAccountRepository,
                          PasswordEncoder passwordEncoder,
                          JwtTokenProvider jwtTokenProvider) {
        this.userAccountRepository = userAccountRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest request) {

        // ✅ Fetch user
        UserAccount userAccount = userAccountRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // ✅ Validate password
        if (!passwordEncoder.matches(request.getPassword(), userAccount.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        // ✅ Generate JWT using STRING (email)
        String token = jwtTokenProvider.generateToken(userAccount.getEmail());

        return ResponseEntity.ok(token);
    }
}
