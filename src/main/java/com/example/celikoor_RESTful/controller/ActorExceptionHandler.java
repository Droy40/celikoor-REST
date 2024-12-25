package com.example.celikoor_RESTful.controller;

import com.example.celikoor_RESTful.dto.ActorErrorResponse;
import com.example.celikoor_RESTful.exception.ActorNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ActorExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ActorErrorResponse> actorNotFoundHandler (ActorNotFoundException ex, HttpServletRequest req) {
        ActorErrorResponse error = new ActorErrorResponse(
                ZonedDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                req.getRequestURI(),
                ex.getMessage()
        );
        return new ResponseEntity<> (error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<ActorErrorResponse> genericHandler ( Exception ex, HttpServletRequest req){
        ActorErrorResponse error = new ActorErrorResponse(
                ZonedDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                req.getRequestURI(),
                ex.getMessage());

        return new ResponseEntity<> (error, HttpStatus.BAD_REQUEST);
    }
}
