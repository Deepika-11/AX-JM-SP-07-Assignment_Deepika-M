package com.employemanagementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({InvalidEmployeeIdException.class,InvalidDepartmentIdException.class})
    public ResponseEntity<ErrorResponse> handleExceptionIdNotFound() {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode("404");
        errorResponse.setErrorResponse("The given id is not present");
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler({EmployeeIdExistsException.class,DepartmentIdExistsException.class})
    public ResponseEntity<ErrorResponse> handleExceptionIdExists() {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode("404");
        errorResponse.setErrorResponse("The given id is already present");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


}
