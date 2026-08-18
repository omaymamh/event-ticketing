package com.omayma.event_ticketing.repository;

import com.omayma.event_ticketing.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}