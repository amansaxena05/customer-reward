package com.assignment.customerreward.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.assignment.customerreward.dto.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ApiResponse> handleCustomerNotFoundException(CustomerNotFoundException exp) {
		ApiResponse response = new ApiResponse();
		response.setMessage(exp.getMessage());
		response.setSuccess(true);
		response.setStatus(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
	}
}
