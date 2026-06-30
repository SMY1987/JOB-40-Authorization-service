package com.netology.job40.auth.exception;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AuthExceptionHandler {

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> handleInvalidCredentials(InvalidCredentials ex,
                                                           HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> handleUnauthorizedUser(UnauthorizedUser ex,
                                                         HttpServletResponse response) {
        System.out.println(ex.getMessage());
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED)
                .body(ex.getMessage());
    }
}