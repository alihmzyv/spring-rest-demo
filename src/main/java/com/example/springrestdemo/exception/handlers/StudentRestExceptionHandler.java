package com.example.springrestdemo.exception.handlers;

import com.example.springrestdemo.exception.DefaultExceptionResponse;
import com.example.springrestdemo.exception.custom.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
/*
So, extends @Component, thus this is a component as well.
Specialization of @Component for classes that declare
@ExceptionHandler, @InitBinder, or @ModelAttribute methods to be shared across multiple @Controller classes.
 */
public class StudentRestExceptionHandler {

    @ExceptionHandler({StudentNotFoundException.class})
    public ResponseEntity<DefaultExceptionResponse> handleStudentNotFoundExc(StudentNotFoundException exc) {
        DefaultExceptionResponse excResp = new DefaultExceptionResponse(HttpStatus.NOT_FOUND.value(), exc.getMessage());
        return new ResponseEntity<>(excResp, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({Throwable.class})
    public ResponseEntity<DefaultExceptionResponse> handleBadId(NumberFormatException exc) {
        DefaultExceptionResponse excResp = new DefaultExceptionResponse(
                HttpStatus.BAD_REQUEST.value(), "ID should be an integer.");
        return new ResponseEntity<>(excResp, HttpStatus.BAD_REQUEST);
    }
}
