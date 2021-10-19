package com.news_articles.resource.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> handleRuntimeException(Exception e) {
        logger(e);
        return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // You dont need to worry about logging for this exercise
    private void logger(Exception e) {
        e.printStackTrace();
    }
}
