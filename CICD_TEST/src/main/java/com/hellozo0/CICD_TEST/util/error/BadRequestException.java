package com.hellozo0.CICD_TEST.util.error;

public class BadRequestException extends RuntimeException{
    public BadRequestException(ErrorResponseStatus status){
        super(status.getMessage());
    }
}