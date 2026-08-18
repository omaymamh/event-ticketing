package com.omayma.event_ticketing.exception;

public class EvenementPasseException extends RuntimeException {
    public EvenementPasseException(Long eventId) {
        super("L'evenement " + eventId + " est deja passe");
    }
}