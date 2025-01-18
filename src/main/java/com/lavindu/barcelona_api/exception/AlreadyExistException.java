package com.lavindu.barcelona_api.exception;

public class AlreadyExistException extends NotFoundException{
    public AlreadyExistException(String message) {
        super(message);
    }
}
