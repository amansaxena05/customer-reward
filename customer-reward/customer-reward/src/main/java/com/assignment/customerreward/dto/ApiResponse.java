package com.assignment.customerreward.dto;

import org.springframework.http.HttpStatus;

/**
 * DTO to send in response when Exception occurs
 * @author aman.saxena05
 *
 */
public class ApiResponse {

	private String message;
	
	private boolean success;
	
	private HttpStatus status;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
}
