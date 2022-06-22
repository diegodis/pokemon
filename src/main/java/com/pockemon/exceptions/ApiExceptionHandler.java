package com.pockemon.exceptions;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class ApiExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({HttpClientErrorException.class, Exception.class, })
    @ResponseBody
    public ErrorMessage notFoundRequest(HttpRequest request, Exception exception){
        return new ErrorMessage(exception , "Pockemon not found");
    }
}
