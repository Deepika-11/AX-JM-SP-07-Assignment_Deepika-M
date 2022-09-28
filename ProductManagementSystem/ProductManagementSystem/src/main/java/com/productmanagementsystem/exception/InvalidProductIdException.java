package com.productmanagementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.productmanagementsystem.exception.ErrorResponse;
public class InvalidProductIdException extends RuntimeException {

    public InvalidProductIdException(String msg)
    {
        super(msg);
    }

    public ResponseEntity<ErrorResponse> handleProductException(){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode("404");
        errorResponse.setErrorResponse(super.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
