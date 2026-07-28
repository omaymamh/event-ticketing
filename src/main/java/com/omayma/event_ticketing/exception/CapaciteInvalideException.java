package com.omayma.event_ticketing.exception;

public class CapaciteInvalideException extends RuntimeException {
    public CapaciteInvalideException(int capaciteDemandee, int placesReservees) {
        super("Capacite demandee (" + capaciteDemandee + ") inferieure aux places deja reservees (" + placesReservees + ")");
    }
}
