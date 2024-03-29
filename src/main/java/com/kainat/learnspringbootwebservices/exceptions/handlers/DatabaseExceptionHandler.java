package com.kainat.learnspringbootwebservices.exceptions.handlers;

import com.kainat.learnspringbootwebservices.exceptions.messages.ExceptionMessage;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice(basePackages = "com.kainat.learnspringbootwebservices.persistence")
public class DatabaseExceptionHandler {
    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<Object> handleDataAccessException(DataAccessException ex) {
        Map<String, String> response = new HashMap<>();

        response.put("error", ExceptionMessage.DATABASE_OPERATION_FAILED);
        response.put("message", ex.getLocalizedMessage());

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
