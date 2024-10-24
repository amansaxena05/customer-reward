package com.assignment.customerreward.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.customerreward.dto.CustomerDto;
import com.assignment.customerreward.entity.CustomerEntity;
import com.assignment.customerreward.exception.CustomerNotFoundException;
import com.assignment.customerreward.repository.CustomerRepository;

/**
 * customer service
 * @author aman.saxena05
 *
 */
@Service
public class CustomerService {

	private CustomerRepository repository;
	
	private Logger logger = LoggerFactory.getLogger(com.assignment.customerreward.service.CustomerService.class);
	
	@Autowired
	public CustomerService(CustomerRepository customerRepository) {
		this.repository = customerRepository;
	}
	
	/**
	 * service method to create new customer in DB
	 * @param request
	 * @return
	 */
	public String newCustomer(CustomerDto request) {
		String id = UUID.randomUUID().toString();
		request.setId(id);
		logger.info("saving customer to DB = " + request.toString());
		repository.save(getEntityFromDto(request));
		return id;
	}
	
	/**
	 * service method to get customer details by Id
	 * @param customerId
	 * @return
	 */
	public CustomerDto getCustomerById(String customerId) {
		logger.info("getting customer for id = " + customerId);
		CustomerEntity entity = repository.findById(customerId)
				.orElseThrow(() -> new CustomerNotFoundException("Id - " + customerId + " not found"));
		return convertEntityToDto(entity);
	}
	
	/**
	 * converting customer entity to dto
	 * @param entity
	 * @return
	 */
	public CustomerDto convertEntityToDto(CustomerEntity entity) {
		CustomerDto dto = new CustomerDto();
		dto.setEmail(entity.getEmail());
		dto.setId(entity.getCustomerId());
		dto.setName(entity.getName());
		dto.setPhoneNumber(entity.getPhoneNumber());
		return dto;
	}
	
	/**
	 * converting customer dto to entity
	 * @param dto
	 * @return
	 */
	public CustomerEntity getEntityFromDto(CustomerDto dto) {
		CustomerEntity entity = new CustomerEntity();
		entity.setCustomerId(dto.getId());
		entity.setEmail(dto.getEmail());
		entity.setName(dto.getName());
		entity.setPhoneNumber(dto.getPhoneNumber());
		return entity;
	}
}
