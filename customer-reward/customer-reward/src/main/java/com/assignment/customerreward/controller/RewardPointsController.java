package com.assignment.customerreward.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.customerreward.dto.RewardPointsDto;
import com.assignment.customerreward.service.CustomerService;
import com.assignment.customerreward.service.RewardPointService;

@RestController
@RequestMapping(value = "/rewardPoints")
public class RewardPointsController {
	
	private RewardPointService rewardPointService;
	
	private CustomerService customerService;
	
	@Autowired
	public RewardPointsController (RewardPointService rewardPoint, 
			CustomerService customer) {
		this.rewardPointService = rewardPoint;
		this.customerService = customer;
	}

	@GetMapping(value = "/getByCustomerId/{customerId}")
	public ResponseEntity<List<RewardPointsDto>> getRewardPointsByCustomerId(@PathVariable String customerId) {
		return ResponseEntity.status(HttpStatus.OK).body(rewardPointService.getRewardPointByCustomerId(customerId));
	}
}
