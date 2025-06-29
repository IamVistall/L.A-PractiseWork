package com.example.fjv_hospitalmanagementsystem.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidStaffDataException.class)
    public ResponseEntity<String> handleInvalidStaffDataException(InvalidStaffDataException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidAppointmentDataException.class)
    public ResponseEntity<String> handleInvalidAppointmentDataException(InvalidAppointmentDataException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
