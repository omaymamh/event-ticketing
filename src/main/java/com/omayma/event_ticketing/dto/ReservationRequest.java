package com.omayma.event_ticketing.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationRequest {

    @NotNull(message = "l'id de l'evenement est obligatoire")
    private Long eventId;
}