package com.assignment.customerreward.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.customerreward.dto.CustomerDto;
import com.assignment.customerreward.dto.RewardPointsDto;
import com.assignment.customerreward.service.CustomerService;
import com.assignment.customerreward.service.RewardPointService;

/**
 * Customer Reward Points controller for rest endpoints for rewards
 * @author aman.saxena05
 *
 */
@RestController
@RequestMapping(value = "/rewardPoints")
public class RewardPointsController {
	
	/**
	 * reward service
	 */
	private RewardPointService rewardPointService;
	
	
	@Autowired
	public RewardPointsController (RewardPointService rewardPoint) {
		this.rewardPointService = rewardPoint;
	}

	/**
	 * get reward details by customer id
	 * @param customerId
	 * @return
	 */
	@GetMapping(value = "/getByCustomerId/{customerId}")
	public ResponseEntity<CustomerDto> getRewardPointsByCustomerId(@PathVariable String customerId) {
		return ResponseEntity.status(HttpStatus.OK).body(rewardPointService.getRewardPointByCustomerId(customerId));
	}
	
}
