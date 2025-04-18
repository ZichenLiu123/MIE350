package com.example.cms.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TequilaNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(TequilaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String TequilaNotFoundHandler(TequilaNotFoundException ex) {
        return ex.getMessage();
    }
}
