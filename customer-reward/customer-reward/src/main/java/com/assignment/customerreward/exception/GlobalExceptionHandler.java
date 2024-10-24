package com.assignment.customerreward.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.assignment.customerreward.dto.ApiResponse;

/**
 * GlobalExceptionHandler
 * @author aman.saxena05
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * Exception Handler for CustomerNotFoundException
	 * @param exp
	 * @return
	 */
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ApiResponse> handleCustomerNotFoundException(CustomerNotFoundException exp) {
		ApiResponse response = new ApiResponse();
		response.setMessage(exp.getMessage());
		response.setSuccess(true);
		response.setStatus(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	/**
	 * ExceptionHandler for CustomerTransactionNotFoound Exception
	 * @param exp
	 * @return
	 */
	@ExceptionHandler(CustomerTransactionNotFoundException.class)
	public ResponseEntity<ApiResponse> handleCustomerTransactionNotFoundException(CustomerTransactionNotFoundException exp) {
		ApiResponse response = new ApiResponse();
		response.setMessage(exp.getMessage());
		response.setSuccess(true);
		response.setStatus(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	/**
	 * ExceptionHandler for MethodArgumentNotValidException
	 * @param exp
	 * @return
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exp) {
		ApiResponse response = new ApiResponse();
		exp.getBindingResult().getAllErrors().forEach((error) -> {
			response.setMessage(error.getDefaultMessage());
		});
		response.setSuccess(false);
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		
		return new ResponseEntity<ApiResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
