package com.assignment.customerreward.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.customerreward.dto.RewardPointsDto;
import com.assignment.customerreward.entity.CustomerEntity;
import com.assignment.customerreward.entity.RewardPoints;
import com.assignment.customerreward.repository.RewardPointsRepository;

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
	
	public String insertNewRewardDetails(RewardPointsDto request) {
		String rewardId = UUID.randomUUID().toString();
		request.setRewardId(rewardId);
		rewardPointsRepository.save(getEntityFromDto(request));
		return rewardId;
	}
	
	public List<RewardPointsDto> getRewardPointByCustomerId(String customerId) {
		CustomerEntity customerEntity = customerService.getEntityFromDto(customerService.getCustomerById(customerId));
		List<RewardPoints> rewardPoints = rewardPointsRepository.findByCustomer(customerEntity);
		List<RewardPointsDto> dtoList = rewardPoints.stream()
				.map(entity -> {
					return getDtoFromEntity(entity);
				}).collect(Collectors.toList());
		return dtoList;
		
	}
	
	public RewardPoints getEntityFromDto(RewardPointsDto dto) {
		RewardPoints entity = new RewardPoints();
		entity.setCustomer(customerService.getEntityFromDto(customerService.getCustomerById(dto.getCustomerId())));
		entity.setMonth(dto.getMonth());
		entity.setPoints(dto.getPoints());
		entity.setRewardId(dto.getRewardId());
		entity.setYear(dto.getYear());
		return entity;
	}
	
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
