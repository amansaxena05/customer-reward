package com.assignment.customerreward.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.customerreward.dto.CustomerTransactionDto;
import com.assignment.customerreward.service.CustomerTransactionService;

@RestController
@RequestMapping(value = "/transaction")
public class CustomerTransactionController {

	private CustomerTransactionService transactionService;
	
	@Autowired
	public CustomerTransactionController (CustomerTransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
	@PostMapping(value = "/newTransaction")
	public ResponseEntity<String> newTransaction(@RequestBody CustomerTransactionDto request) {
		return ResponseEntity.status(HttpStatus.CREATED).body(transactionService.newTransaction(request));
	}
}
