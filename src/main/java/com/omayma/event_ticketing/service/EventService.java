package com.omayma.event_ticketing.service;

import com.omayma.event_ticketing.dto.CreateEventRequest;
import com.omayma.event_ticketing.exception.EventIntrouvableException;
import com.omayma.event_ticketing.model.Event;
import com.omayma.event_ticketing.repository.EventRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepository;
    public EventService(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }
    public Event creerEvent(CreateEventRequest request){
        Event event = new Event();
        event.setNom(request.getNom());
        event.setDescription(request.getDescription());
        event.setDateHeure(request.getDateHeure());
        event.setLieu(request.getLieu());
        event.setCapacite(request.getCapacite());
        return eventRepository.save(event);
    }
    public List<Event> listerEvents(){
        return eventRepository.findAll();
    }
    public Event trouverParId(Long id ){
        return eventRepository.findById(id).orElseThrow(() -> new EventIntrouvableException(id));

    }

}
