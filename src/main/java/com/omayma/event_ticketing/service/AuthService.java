package com.omayma.event_ticketing.service;

import com.omayma.event_ticketing.dto.RegisterRequest;
import com.omayma.event_ticketing.model.User;
import com.omayma.event_ticketing.dto.LoginResponse;
import com.omayma.event_ticketing.dto.LoginRequest;

public interface AuthService {
    User register(RegisterRequest request);
    LoginResponse login(LoginRequest request);

}
