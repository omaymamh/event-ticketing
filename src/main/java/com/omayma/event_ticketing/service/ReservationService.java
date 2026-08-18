package com.omayma.event_ticketing.service;

import com.omayma.event_ticketing.dto.ReservationRequest;
import com.omayma.event_ticketing.model.Reservation;

public interface ReservationService {
    Reservation reserver(ReservationRequest request, String emailUser);
}