package com.omayma.event_ticketing.exception;

import com.omayma.event_ticketing.dto.LoginResponse;
import com.omayma.event_ticketing.dto.LoginRequest;

public class IdentifiantsInvalidesException  extends RuntimeException{
    public IdentifiantsInvalidesException() {
        super("Email ou mot de passe incorrect");
    }
}
