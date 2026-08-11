package com.omayma.event_ticketing.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

    @NotBlank(message = "l'email est obligatoire")
    private String email;

    @NotBlank(message = "le mot de passe est obligatoire")
    private String motDePasse;
}