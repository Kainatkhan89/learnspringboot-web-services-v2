package com.kainat.learnspringbootwebservices.exceptions.handlers;

import com.kainat.learnspringbootwebservices.exceptions.custom.DuplicateResourceException;
import com.kainat.learnspringbootwebservices.exceptions.custom.ResourceNotFoundException;
import com.kainat.learnspringbootwebservices.exceptions.messages.ExceptionMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice(basePackages = "com.kainat.learnspringbootwebservices.api")
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex) {
        Map<String, Object> body = new LinkedHashMap<>();

        body.put("error", ExceptionMessage.NOT_FOUND_ERROR);
        body.put("message", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<Object> handleDuplicateResourceFoundException(DuplicateResourceException ex) {
        Map<String, Object> body = new LinkedHashMap<>();

        body.put("error", ExceptionMessage.RESOURCE_ALREADY_EXISTS_ERROR);
        body.put("message", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.CONFLICT);
    }
}
