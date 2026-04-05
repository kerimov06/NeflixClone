package com.turankerimov.excption;

import lombok.Getter;

import org.springframework.http.HttpStatus;


@Getter
public enum ErrorCode {

    NOT_FOUND(HttpStatus.NOT_FOUND,"That information could not be found"),
    GLOBAL_CONFLICT_ERROR(HttpStatus.CONFLICT,"Have some global conflict");

    private HttpStatus httpStatus;
    private String message;


    private ErrorCode(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
