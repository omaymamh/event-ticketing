package com.omayma.event_ticketing.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> gererErreursValidation(MethodArgumentNotValidException ex) {
        Map<String, String> erreurs = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(erreur ->
                erreurs.put(erreur.getField(), erreur.getDefaultMessage())
        );
        return erreurs;
    }

    @ExceptionHandler(EventIntrouvableException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> gererEventIntrouvable(EventIntrouvableException ex) {
        Map<String, String> erreur = new HashMap<>();
        erreur.put("erreur", ex.getMessage());
        return erreur;
    }
    @ExceptionHandler(CapaciteInvalideException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, String> gererCapaciteInvalide(CapaciteInvalideException ex){
        Map<String, String> erreur =new HashMap<>();
        erreur.put("erreur", ex.getMessage());
        return erreur;
    }
}

