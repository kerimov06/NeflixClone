package com.turankerimov.excption;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Builder
public class ExceptionResponse {


    private final String message;
    private final int status;
    private final String path;
    private final LocalDateTime timestamp;


}
