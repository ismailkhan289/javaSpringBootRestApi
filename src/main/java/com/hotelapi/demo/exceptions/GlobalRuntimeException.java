package com.hotelapi.demo.exceptions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalRuntimeException extends ResponseEntityExceptionHandler{

    @Override
    @Nullable
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
        HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String message=ex.getMessage();
        List<String> details = new ArrayList<>();
        details.add("Media Type Not supported");
        Apierrors errors= new Apierrors(message, details,status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errors);
    }

    @Override
    @Nullable
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {
            String message=ex.getMessage();
            List<String> details = new ArrayList<>();
            details.add("Http Request Method is not Suupported");
            details.add(ex.getMessage());
            Apierrors errors=new Apierrors(message,details,status,LocalDateTime.now());
            return ResponseEntity.status(status).body(errors);    
    }

    @Override
    @Nullable
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
            HttpStatusCode status, WebRequest request) {
            String message=ex.getMessage();
            List<String> details = new ArrayList<>();
            details.add("Path variable is missing");
            details.add(ex.getMessage());
            Apierrors errors=new Apierrors(message,details,status,LocalDateTime.now());
            return ResponseEntity.status(status).body(errors);  
    }

    @Override
    @Nullable
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
            HttpStatusCode status, WebRequest request) {
            String message=ex.getMessage();
            List<String> details = new ArrayList<>();
            details.add("Mismatch of type");
            Apierrors errors=new Apierrors(message,details,status,LocalDateTime.now());
            return ResponseEntity.status(status).body(errors);
    }
    @ExceptionHandler(HotelNotFoundException.class)
    public ResponseEntity<Object> handleHotelNotFound(HotelNotFoundException ex){
        String message=ex.getMessage();
        List<String> details = new ArrayList<>();
        details.add("Hotel is not found");
        Apierrors errors=new Apierrors(message,details,HttpStatus.BAD_REQUEST,LocalDateTime.now());
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(HotelIdNotFoundException.class)
    public ResponseEntity<Object> handleHotelIdNotFound(HotelIdNotFoundException ex){
        String message=ex.getMessage();
        List<String> details=new ArrayList<>();
        details.add("Hotel Id is not found");
        Apierrors errors=new Apierrors(message, details, HttpStatus.NOT_FOUND, LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllException(Exception ex){
        String message=ex.getMessage();
        List<String> details=new ArrayList<>();
        details.add("Other Exception");
        Apierrors errors=new Apierrors(message, details, HttpStatus.NOT_FOUND, LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
    }
    
}
