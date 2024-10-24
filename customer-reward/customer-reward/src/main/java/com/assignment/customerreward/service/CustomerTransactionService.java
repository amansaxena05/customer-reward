package com.assignment.customerreward.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.customerreward.dto.CustomerTransactionDto;
import com.assignment.customerreward.dto.RewardPointsDto;
import com.assignment.customerreward.entity.CustomerTransaction;
import com.assignment.customerreward.exception.CustomerTransactionNotFoundException;
import com.assignment.customerreward.repository.CustomerTransactionRepository;

/**
 * Customer Transaction Service
 * @author aman.saxena05
 *
 */
@Service
public class CustomerTransactionService {

	
	private Logger logger = LoggerFactory.getLogger(com.assignment.customerreward.service.CustomerTransactionService.class);
	
	private CustomerTransactionRepository repository;
	
	private CustomerService customerService;
	
	private RewardPointService rewardPointService;
	
	@Autowired
	public CustomerTransactionService (CustomerTransactionRepository transactionRepository, 
			CustomerService customerService, 
			RewardPointService rewardPointService) {
		this.repository = transactionRepository;
		this.customerService = customerService;
		this.rewardPointService = rewardPointService;
	}
	
	/**
	 * service method to create new transaction
	 * @param request
	 * @return
	 */
	public String newTransaction (CustomerTransactionDto request) {
		String id = UUID.randomUUID().toString();
		request.setTransactionId(id);
		logger.info("saving transaction = " + request.toString());
		repository.save(getEntityFromDto(request));
		int rewardPoint = calculateRewardPoints(request);
		RewardPointsDto rewardPointdto = new RewardPointsDto();
		rewardPointdto.setCustomerId(request.getCustomerId());
		rewardPointdto.setMonth(request.getDate().getMonthValue());
		rewardPointdto.setPoints(rewardPoint);
		rewardPointdto.setYear(request.getDate().getYear());
		rewardPointService.insertNewRewardDetails(rewardPointdto);
		return id;
	}
	
	/**
	 * servic method to get transaction by transaction Id
	 * @param transactionId
	 * @return
	 */
	public CustomerTransactionDto getTransactionById(String transactionId) {
		CustomerTransaction entity = repository.findById(transactionId)
				.orElseThrow(() -> new CustomerTransactionNotFoundException("Transaction id - " + transactionId + " not found"));
		return getDtoFromEntity(entity);
	}
	
	/**
	 * method to get customer transaction dto from entity
	 * @param entity
	 * @return
	 */
	private CustomerTransactionDto getDtoFromEntity(CustomerTransaction entity) {
		CustomerTransactionDto dto = new CustomerTransactionDto();
		dto.setAmount(entity.getAmount());
		dto.setCustomerId(entity.getCustomer().getCustomerId());
		dto.setDate(entity.getDate());
		dto.setSpentDetails(entity.getSpentDetails());
		dto.setTransactionId(entity.getTransactionId());
		return dto;
	}
	
	/**
	 * method to get customer transaction entity from dto
	 * @param dto
	 * @return
	 */
	private CustomerTransaction getEntityFromDto(CustomerTransactionDto dto) {
		CustomerTransaction entity = new CustomerTransaction();
		entity.setAmount(dto.getAmount());
		entity.setDate(dto.getDate());
		entity.setSpentDetails(dto.getSpentDetails());
		entity.setTransactionId(dto.getTransactionId());
		entity.setCustomer(customerService.getEntityFromDto(customerService.getCustomerById(dto.getCustomerId())));
		return entity;
	}
	
	/**
	 * method to calculate reward points from transaction amount
	 * @param request
	 * @return
	 */
	private int calculateRewardPoints(CustomerTransactionDto request) {
		if (request.getAmount() < 50) {
			return 0;
		} else if (request.getAmount() >= 50 && request.getAmount() < 100) {
			return request.getAmount() - 50;
		} else if (request.getAmount() >= 100) {
			return (((request.getAmount() - 100) * 2) + 50);
		}
		return 0;
	}
}
