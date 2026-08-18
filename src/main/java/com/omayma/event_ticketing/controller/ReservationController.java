package com.omayma.event_ticketing.controller;

import com.omayma.event_ticketing.dto.ReservationRequest;
import com.omayma.event_ticketing.model.Reservation;
import com.omayma.event_ticketing.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ResponseEntity<Reservation> reserver(
            @Valid @RequestBody ReservationRequest request,
            Authentication authentication) {

        String emailUser = authentication.getName();
        Reservation reservation = reservationService.reserver(request, emailUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(reservation);
    }
}