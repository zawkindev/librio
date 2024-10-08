package com.example.demo.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerHandler {
    @ExceptionHandler(LyuboyException.class)
    public ResponseEntity<String> handle(LyuboyException e){
        return ResponseEntity.ok(e.getMessage());
    }
}