package com.omayma.event_ticketing.exception;

public class EvenementCompletException extends RuntimeException {
    public EvenementCompletException(Long eventId) {
        super("L'evenement " + eventId + " est complet, plus de places disponibles");
    }
}