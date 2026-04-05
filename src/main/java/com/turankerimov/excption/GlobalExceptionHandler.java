package com.turankerimov.excption;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ExceptionResponse> handleBaseException(BaseException e, HttpServletRequest request) {

        ErrorCode errorCode = e.getErrorCode();


        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .message(e.getMessage())
                .path(request.getRequestURI())
                .status(errorCode.getHttpStatus().value())
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(errorCode.getHttpStatus()).body(exceptionResponse);

    }
}
