package com.omayma.event_ticketing.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import com.omayma.event_ticketing.model.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    @NotBlank(message = "l'email est obligatoire")
    @Email(message = "l'email doit etre validé")
    private String email;

    @NotBlank(message = "le mot de passe est obligatoire")
    private String motDePasse;

    @NotNull(message = "le role est obligatoire")
    private Role role;
}