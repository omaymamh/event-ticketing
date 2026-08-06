package com.omayma.event_ticketing.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.Builder;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name= "events")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Event {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String nom;

    @Column(length=1000)
    private String description;

    @Column(nullable =false)
    private LocalDateTime dateHeure;

    @Column(nullable =false)
    private String lieu;

    @Column(nullable =false)
    private int capacite;

    @Column (nullable=false)
    private int placesReservees=0;





}
