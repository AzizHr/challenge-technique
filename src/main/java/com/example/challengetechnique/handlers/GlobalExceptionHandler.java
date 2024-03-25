package com.example.challengetechnique.handlers;

import com.example.challengetechnique.exceptions.EmailAlreadyInUseException;
import com.example.challengetechnique.exceptions.InvalidCountValueException;
import com.example.challengetechnique.exceptions.UsernameAlreadyInUseException;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleUsernameNotFoundException(UsernameNotFoundException e) {
        return new ResponseEntity<>(Map.of("message", e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailAlreadyInUseException.class)
    public ResponseEntity<Map<String, String>> handleEmailAlreadyInUseException(EmailAlreadyInUseException e) {
        return new ResponseEntity<>(Map.of("message", e.getMessage()), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(UsernameAlreadyInUseException.class)
    public ResponseEntity<Map<String, String>> handleUsernameAlreadyInUseException(UsernameAlreadyInUseException e) {
        return new ResponseEntity<>(Map.of("message", e.getMessage()), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Map<String, String>> handleBadRequestException(BadRequestException e) {
        return new ResponseEntity<>(Map.of("message", e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidCountValueException.class)
    public ResponseEntity<Map<String, String>> handleInvalidCountValueException(InvalidCountValueException e) {
        return new ResponseEntity<>(Map.of("message", e.getMessage()), HttpStatus.FORBIDDEN);
    }

}
