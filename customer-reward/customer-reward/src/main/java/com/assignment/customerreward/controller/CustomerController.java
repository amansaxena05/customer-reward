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

import com.assignment.customerreward.dto.CustomerDto;
import com.assignment.customerreward.service.CustomerService;


@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

	
	private CustomerService service;
	
	@Autowired
	public CustomerController (CustomerService customerService) {
		this.service = customerService;
	}
	
	@PostMapping(value = "/newCustomer")
	public ResponseEntity<String> newCustomer(@RequestBody CustomerDto request) {
		return ResponseEntity.status(HttpStatus.OK).body(service.newCustomer(request));
	}
	
	@GetMapping(value = "/getCustomer/{id}")
	public ResponseEntity<CustomerDto> getCustomerById(@PathVariable String id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.getCustomerById(id));
	}
}
