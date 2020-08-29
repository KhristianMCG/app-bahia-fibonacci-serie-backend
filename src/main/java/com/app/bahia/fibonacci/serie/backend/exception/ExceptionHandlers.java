package com.app.bahia.fibonacci.serie.backend.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlers.class);

    @ExceptionHandler
    public ResponseEntity<String> handle(NumberFormatException ex) {
        String message = "Sorry, for generate the fibonacci serie need a number, please try again.";
        LOGGER.warn(message, ex);
        return ResponseEntity.badRequest().body(message);
    }

    @ExceptionHandler
    public ResponseEntity<String> handle(IllegalArgumentException ex) {
        String message = "Sorry, only positive numbers allowed here. Please introduce number from ZERO.";
        LOGGER.warn(message, ex);
        return ResponseEntity.badRequest().body(message);
    }
}
