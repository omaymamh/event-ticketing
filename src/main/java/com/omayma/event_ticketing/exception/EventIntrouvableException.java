package com.omayma.event_ticketing.exception;

public class EventIntrouvableException extends RuntimeException {
    public EventIntrouvableException(Long id){
        super("Evenement introuvable avec l'id :" + id);

    }
}
