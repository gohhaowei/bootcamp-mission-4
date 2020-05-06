package com.btkbootcamp.mission3.exception;

public class CarNotFoundException extends RuntimeException {

    public CarNotFoundException(String message){
        super(message);
    }

    public CarNotFoundException(String message, Throwable cause){
        super(message, cause);
    }

    public CarNotFoundException(Throwable cause){
        super(cause);
    }
}




