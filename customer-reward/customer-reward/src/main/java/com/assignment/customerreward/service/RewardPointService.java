package com.assignment.customerreward.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.customerreward.dto.CustomerDto;
import com.assignment.customerreward.dto.RewardPointsDto;
import com.assignment.customerreward.entity.CustomerEntity;
import com.assignment.customerreward.entity.RewardPoints;
import com.assignment.customerreward.repository.RewardPointsRepository;

/**
 * RewardPointService
 * @author aman.saxena05
 *
 */
@Service
public class RewardPointService {

	private RewardPointsRepository rewardPointsRepository;
	
	private CustomerService customerService;
	
	@Autowired
	public RewardPointService (RewardPointsRepository repository, 
			CustomerService customerService) {
		this.rewardPointsRepository = repository;
		this.customerService = customerService;
	}
	
	/**
	 * service method to insert new reward details
	 * @param request
	 * @return
	 */
	public String insertNewRewardDetails(RewardPointsDto request) {
		String rewardId = UUID.randomUUID().toString();
		request.setRewardId(rewardId);
		rewardPointsRepository.save(getEntityFromDto(request));
		return rewardId;
	}
	
	/**
	 * service method to get reward points by customer id
	 * @param customerId
	 * @return
	 */
	public CustomerDto getRewardPointByCustomerId(String customerId) {
		CustomerEntity customerEntity = customerService.getEntityFromDto(customerService.getCustomerById(customerId));
		CustomerDto customerDto = customerService.convertEntityToDto(customerEntity);
		List<RewardPoints> rewardPoints = rewardPointsRepository.findByCustomer(customerEntity);
		int totalRewardPoints = 0;
		List<RewardPointsDto> dtoList = new ArrayList<>();
		for (RewardPoints entity : rewardPoints) {
			RewardPointsDto dto = getDtoFromEntity(entity);
			totalRewardPoints += dto.getPoints();
			dtoList.add(dto);
			
		}
		customerDto.setRewardPointsDtoList(dtoList);
		customerDto.setTotalRewardPoints(totalRewardPoints);
		return customerDto;
		
	}
	
	/**
	 * method to get reward points entity from dto
	 * @param dto
	 * @return
	 */
	public RewardPoints getEntityFromDto(RewardPointsDto dto) {
		RewardPoints entity = new RewardPoints();
		entity.setCustomer(customerService.getEntityFromDto(customerService.getCustomerById(dto.getCustomerId())));
		entity.setMonth(dto.getMonth());
		entity.setPoints(dto.getPoints());
		entity.setRewardId(dto.getRewardId());
		entity.setYear(dto.getYear());
		return entity;
	}
	
	/**
	 * method to get reward points dto from entity
	 * @param entity
	 * @return
	 */
	public RewardPointsDto getDtoFromEntity(RewardPoints entity) {
		RewardPointsDto dto = new RewardPointsDto();
		dto.setCustomerId(entity.getCustomer().getCustomerId());
		dto.setMonth(entity.getMonth());
		dto.setPoints(entity.getPoints());
		dto.setRewardId(entity.getRewardId());
		dto.setYear(entity.getYear());
		return dto;
	}
}
