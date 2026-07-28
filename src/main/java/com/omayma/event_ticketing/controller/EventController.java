package com.omayma.event_ticketing.controller;

import com.omayma.event_ticketing.dto.UpdateEventRequest;
import com.omayma.event_ticketing.model.Event;
import com.omayma.event_ticketing.service.EventService;
import com.omayma.event_ticketing.dto.CreateEventRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService){
        this.eventService =eventService;
    }
    @PostMapping
    public ResponseEntity<Event> creer(@Valid @RequestBody CreateEventRequest request) {
        Event cree = eventService.creerEvent(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(cree);
    }
    @GetMapping
    public List<Event> lister(){
        return eventService.listerEvents();
    }

    @GetMapping("/{id}")
    public Event Truver(@PathVariable Long id){
        return eventService.trouverParId(id);
    }

    @PutMapping("/{id}")
    @ExceptionHandler()
    public Event modifier(@PathVariable Long id, @Valid @RequestBody UpdateEventRequest request ){
        return eventService.modifierEvent(id, request);
    }
}
