package com.btkbootcamp.mission3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<RestErrorResponse> handleException(CarNotFoundException e){
        HttpStatus httpStatus = HttpStatus.NOT_FOUND; //HTTP 404
        RestErrorResponse restErrorResponse = new RestErrorResponse();
        restErrorResponse.setStatus(httpStatus.value());
        restErrorResponse.setMessage(e.getMessage());
        restErrorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<RestErrorResponse>(restErrorResponse, httpStatus);
    }

    @ExceptionHandler
    public ResponseEntity<RestErrorResponse> handleException(Exception e){
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR; //HTTP 500
        RestErrorResponse restErrorResponse = new RestErrorResponse();
        restErrorResponse.setStatus(httpStatus.value());
        restErrorResponse.setMessage(e.getMessage());
        restErrorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<RestErrorResponse>(restErrorResponse, httpStatus);
    }
}
