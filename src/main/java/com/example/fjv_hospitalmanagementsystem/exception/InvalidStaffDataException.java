package com.example.fjv_hospitalmanagementsystem.exception;

public class InvalidStaffDataException extends RuntimeException {
    public InvalidStaffDataException( String message) {

        super("Invalid Staff Data" + message);

    }
}
