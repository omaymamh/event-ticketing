package com.omayma.event_ticketing.service;

import com.omayma.event_ticketing.dto.ReservationRequest;
import com.omayma.event_ticketing.exception.*;
import com.omayma.event_ticketing.model.*;
import com.omayma.event_ticketing.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final TicketRepository ticketRepository;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository,
                                  TicketRepository ticketRepository,
                                  EventRepository eventRepository,
                                  UserRepository userRepository) {
        this.reservationRepository = reservationRepository;
        this.ticketRepository = ticketRepository;
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Reservation reserver(ReservationRequest request, String emailUser) {
        // 1. Récupérer l'événement et l'utilisateur
        Event event = eventRepository.findById(request.getEventId())
                .orElseThrow(() -> new EventIntrouvableException(request.getEventId()));

        User user = userRepository.findByEmail(emailUser)
                .orElseThrow(() -> new EventIntrouvableException(request.getEventId()));

        // 2. Vérifier que l'événement est futur
        if (event.getDateHeure().isBefore(LocalDateTime.now())) {
            throw new EvenementPasseException(event.getId());
        }

        // 3. Vérifier qu'il reste des places
        if (event.getPlacesReservees() >= event.getCapacite()) {
            throw new EvenementCompletException(event.getId());
        }

        // 4. Incrémenter le compteur de places
        event.setPlacesReservees(event.getPlacesReservees() + 1);
        eventRepository.save(event);

        // 5. Créer la réservation
        Reservation reservation = Reservation.builder()
                .user(user)
                .event(event)
                .dateReservation(LocalDateTime.now())
                .statut(StatutReservation.CONFIRMEE)
                .build();
        reservation = reservationRepository.save(reservation);

        // 6. Générer le ticket avec un code UUID unique
        Ticket ticket = Ticket.builder()
                .codeUnique(UUID.randomUUID().toString())
                .reservation(reservation)
                .statut(StatutTicket.VALIDE)
                .build();
        ticketRepository.save(ticket);

        return reservation;
    }
}