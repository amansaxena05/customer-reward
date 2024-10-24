package com.assignment.customerreward.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.customerreward.dto.CustomerTransactionDto;
import com.assignment.customerreward.service.CustomerTransactionService;

/**
 * CustomerTransactionController for rest endpoints for transaction
 * @author aman.saxena05
 *
 */
@RestController
@RequestMapping(value = "/transaction")
public class CustomerTransactionController {

	/**
	 * transaction Service
	 */
	private CustomerTransactionService transactionService;
	
	@Autowired
	public CustomerTransactionController (CustomerTransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
	/**
	 * creating new transaction
	 * @param request
	 * @return
	 */
	@PostMapping(value = "/newTransaction")
	public ResponseEntity<String> newTransaction(@RequestBody CustomerTransactionDto request) {
		return ResponseEntity.status(HttpStatus.CREATED).body(transactionService.newTransaction(request));
	}
	
	/**
	 * get transaction details by transaction id
	 * @param transactionId
	 * @return
	 */
	@GetMapping(value = "/getById/{transactionId}")
	public ResponseEntity<CustomerTransactionDto> getTransactionById(@PathVariable String transactionId) {
		return ResponseEntity.status(HttpStatus.OK).body(transactionService.getTransactionById(transactionId));
	}
}
