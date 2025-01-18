package com.lavindu.barcelona_api.exception;

import com.lavindu.barcelona_api.controller.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@RestControllerAdvice
public class AppControllerAdvisor {

    @ExceptionHandler(AlreadyExistException.class)
    public ErrorResponse handleAlreadyExistException(AlreadyExistException ex) {

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(ex.getMessage());
        return errorResponse;
    }



}
