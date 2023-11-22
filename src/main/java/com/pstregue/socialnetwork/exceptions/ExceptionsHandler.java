package com.pstregue.socialnetwork.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@Slf4j
@ControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<StandardError> userAlreadyExistsException(UserAlreadyExistsException e, HttpServletRequest request) {
        String errorMessage = "Usuário com esse e-mail já existe";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), errorMessage, e.getMessage(), request.getRequestURI());
        log.error(e.getMessage());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<StandardError> userNotFoundException(UserNotFoundException e, HttpServletRequest request) {
        String errorMessage = "Usuário com esse e-mail não encontrado";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), errorMessage, e.getMessage(), request.getRequestURI());
        log.error(e.getMessage());
        return ResponseEntity.status(status).body(err);
    }
}
