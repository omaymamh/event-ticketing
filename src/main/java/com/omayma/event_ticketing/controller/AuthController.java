package com.omayma.event_ticketing.controller;

import com.omayma.event_ticketing.dto.RegisterRequest;
import com.omayma.event_ticketing.model.User;
import com.omayma.event_ticketing.service.AuthService;
import  jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")

public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody RegisterRequest request) {
        User cree = authService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(cree);
    }
}
