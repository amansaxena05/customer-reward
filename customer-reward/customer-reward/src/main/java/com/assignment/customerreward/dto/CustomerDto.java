package com.assignment.customerreward.dto;


import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

/**
 * CustomerDto to be accepted and send in request and response
 * @author aman.saxena05
 *
 */
public class CustomerDto {

	private String id;
	
	@NotEmpty(message = "name cannot be null or empty")
	@Size(min = 2, message = "name should be atleast size 2")
	private String name;
	
	@NotEmpty(message = "email cannot be null or empty")
	private String email;
	
	@NotEmpty(message = "phone number cannot be null or empty")
	@Size(min = 2, max = 13, message = "phone number size should be minimum 10")
	private String phoneNumber;
	
	private List<RewardPointsDto> rewardPointsDtoList;
	
	private int totalRewardPoints;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public List<RewardPointsDto> getRewardPointsDtoList() {
		return rewardPointsDtoList;
	}

	public void setRewardPointsDtoList(List<RewardPointsDto> rewardPointsDtoList) {
		this.rewardPointsDtoList = rewardPointsDtoList;
	}
	
	public int getTotalRewardPoints() {
		return totalRewardPoints;
	}

	public void setTotalRewardPoints(int totalRewardPoints) {
		this.totalRewardPoints = totalRewardPoints;
	}

	@Override
	public String toString() {
		return "CustomerDto [id=" + id + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}
	
}
