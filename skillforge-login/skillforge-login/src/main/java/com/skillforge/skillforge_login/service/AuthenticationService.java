package com.skillforge.skillforge_login.service;
import com.skillforge.skillforge_login.model.AuthRequest;
import com.skillforge.skillforge_login.model.AuthResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
 
@Service

public class AuthenticationService {
private final AuthenticationManager authenticationManager;
private final JwtService jwtService;


public AuthenticationService(AuthenticationManager authenticationManager, JwtService jwtService) {
this.authenticationManager = authenticationManager;
this.jwtService = jwtService;
}


public AuthResponse authenticate(AuthRequest request) {
Authentication auth = authenticationManager.authenticate(
new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
);


String token = jwtService.generateToken(request.getEmail());
return new AuthResponse(token);
}
}
