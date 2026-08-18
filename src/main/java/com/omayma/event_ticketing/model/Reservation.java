package com.omayma.event_ticketing.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Reservation {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id" , nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name="event_id" , nullable = false)
    private Event event;

    @Column(nullable = false)
    private LocalDateTime dateReservation;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatutReservation statut;
}
