package com.sitarski.truckparkserver.exceptionhandler;

import com.sitarski.truckparkserver.exception.TruckDriverWayNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TruckDriverWayNotFoundExceptionHandler {

    @ExceptionHandler(TruckDriverWayNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody ExceptionResponse handleTruckDriverWayNotFound(final TruckDriverWayNotFoundException truckDriverWayNotFoundException) {

        ExceptionResponse error = new ExceptionResponse();
        error.setErrorMessage(truckDriverWayNotFoundException.getMessage());

        return error;
    }

}
