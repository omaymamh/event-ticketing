package com.omayma.event_ticketing.service;

import com.omayma.event_ticketing.dto.RegisterRequest;
import com.omayma.event_ticketing.model.User;
import com.omayma.event_ticketing.dto.LoginRequest;
import com.omayma.event_ticketing.dto.LoginResponse;
import com.omayma.event_ticketing.repository.UserRepository;
import com.omayma.event_ticketing.exception.IdentifiantsInvalidesException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImp implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthServiceImp(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    public User register(RegisterRequest request){
        User user =User.builder()
                .email(request.getEmail())
                .motDePasse(passwordEncoder.encode(request.getMotDePasse()))
                .role(request.getRole())
                .build();
        return userRepository.save(user);
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IdentifiantsInvalidesException());

        if (!passwordEncoder.matches(request.getMotDePasse(), user.getMotDePasse())) {
            throw new IdentifiantsInvalidesException();
        }

        String token = jwtService.genererToken(user.getEmail());
        return new LoginResponse(token);
    }
}
