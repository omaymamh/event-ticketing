package com.omayma.event_ticketing.repository;

import com.omayma.event_ticketing.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}