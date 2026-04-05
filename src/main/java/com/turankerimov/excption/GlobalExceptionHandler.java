package com.turankerimov.excption;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.*;

@RestControllerAdvice
public class GlobalExceptionHandler {




    public List<String> addNewValue(List<String> list , String value){
        list.add(value);
        return list;
    }


   @ExceptionHandler(MethodArgumentNotValidException.class)
   public ResponseEntity<ValidationError<?>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {

       Map<String, List<String>> map = new HashMap<>();

       for (ObjectError objects : ex.getBindingResult().getAllErrors()){
          String fieldName = ((FieldError) objects).getField();



          if (map.containsKey(fieldName)){
              map.put(fieldName,addNewValue(map.get(fieldName),objects.getDefaultMessage()));
          }else{
              map.put(fieldName,addNewValue(new ArrayList<>(),objects.getDefaultMessage()));
          }

       }
         return ResponseEntity.badRequest().body(createValidationError(map));
   }


    public <T> ValidationError<T> createValidationError(T exception){
         return ValidationError.<T>builder()
                 .id(UUID.randomUUID().toString()).
                 exception(exception)
                 .createdDate(new Date())
                 .build();
    }




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
