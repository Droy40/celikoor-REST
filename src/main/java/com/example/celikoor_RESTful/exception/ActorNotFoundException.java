package com.example.celikoor_RESTful.exception;


public class ActorNotFoundException extends RuntimeException{
    public ActorNotFoundException() {
        super();
    }
    public ActorNotFoundException(String message) {
        super(message);
    }
    public ActorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public ActorNotFoundException(Throwable cause) {
        super(cause);
    }
}
