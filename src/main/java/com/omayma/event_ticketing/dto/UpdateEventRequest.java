package com.omayma.event_ticketing.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Positive;


import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class UpdateEventRequest {
    @NotBlank(message = "le nom est obligatoire")
    private String nom;

    private String description;

    @NotNull(message = "la date est obligatoire")
    @Future(message = "la date doit etre dans le future")
    private LocalDateTime dateHeure;

    @NotBlank(message ="le lieu est obligatoure")
    private String lieu;

    @Positive(message="la capacité doit etre strictement positive")
    private int capacite;
}
