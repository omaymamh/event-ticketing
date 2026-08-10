package com.omayma.event_ticketing.service;

import com.omayma.event_ticketing.dto.RegisterRequest;
import com.omayma.event_ticketing.model.User;

public interface AuthService {
    User register(RegisterRequest request);

}
