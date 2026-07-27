package com.omayma.event_ticketing.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class CreateEventRequest {

    private String nom;
    private String description;
    private LocalDateTime dateHeure;
    private String lieu;
    private int capacite;

}
