package com.turankerimov.excption;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Builder
public class ValidationError<T> {

    private String id;
    private T exception;
    private Date createdDate;

}
