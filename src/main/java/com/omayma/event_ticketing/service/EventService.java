package com.omayma.event_ticketing.service;

import com.omayma.event_ticketing.dto.CreateEventRequest;
import com.omayma.event_ticketing.dto.UpdateEventRequest;
import com.omayma.event_ticketing.model.Event;
import java.util.List;

public interface EventService {
    Event creerEvent(CreateEventRequest request);
    List<Event> listerEvents();
    Event trouverParId(Long id);
    Event modifierEvent(Long id, UpdateEventRequest request);
    void supprimerEvent(Long id);
}