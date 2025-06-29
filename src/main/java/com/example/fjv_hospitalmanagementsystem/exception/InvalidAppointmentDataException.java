package com.example.fjv_hospitalmanagementsystem.exception;

public class InvalidAppointmentDataException  extends RuntimeException{
    public InvalidAppointmentDataException(String message) {
        super("Appointment data is invalid: " + message);
    }
}
