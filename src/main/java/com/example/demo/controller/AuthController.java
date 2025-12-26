package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.security.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserAccountRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider tokenProvider;

    public AuthController(UserAccountRepository userRepository, 
                         PasswordEncoder passwordEncoder,
                         JwtTokenProvider tokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        UserAccount user = new UserAccount();
        user.setId(1L);
        user.setEmail(request.getEmail());
        user.setRole("USER");
        String token = jwtTokenProvider.generateToken(userAccount.getEmail());

S       String token = jwtTokenProvider.generateToken(userAccount.getEmail());

        AuthResponse response = new AuthResponse(token, user.getEmail(), user.getRole());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        UserAccount user = new UserAccount();
        user.setEmail(request.getEmail());
        user.setRole(request.getRole());
        
        UserAccount saved = userRepository.save(user);
        String token = tokenProvider.generateToken(saved);
        AuthResponse response = new AuthResponse(token, saved.getEmail(), saved.getRole());
        return ResponseEntity.ok(response);
    }
}

