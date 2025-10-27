package com.skillforge.skillforge_login.Controllers;

import com.skillforge.skillforge_login.model.AuthRequest;
import com.skillforge.skillforge_login.model.AuthResponse;
import com.skillforge.skillforge_login.model.User;
import com.skillforge.skillforge_login.Security.JwtUtil;
import com.skillforge.skillforge_login.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    // ✅ LOGIN endpoint
    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        // 1️⃣ Authenticate user credentials
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        // 2️⃣ Fetch user details from DB
        User user = userService.getUserByEmail(request.getEmail());
        if (user == null) {
            throw new RuntimeException("User not found!");
        }

        // 3️⃣ Generate JWT token (pass email and role)
        String token = jwtUtil.generateToken(
        	    user.getEmail(),
        	    user.getRole() != null ? user.getRole().name() : "USER"
        	);

        	return new AuthResponse("Login successful");

    }}
