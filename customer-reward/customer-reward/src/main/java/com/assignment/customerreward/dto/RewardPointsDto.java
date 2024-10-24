package com.assignment.customerreward.dto;

/**
 * RewardPointsDto to be accepted and send in request and response
 * @author aman.saxena05
 *
 */
public class RewardPointsDto {

	private String rewardId;
	
	private int month;
	
	private int year;
	
	private int points;
	
	private String customerId;
	
	public String getRewardId() {
		return rewardId;
	}

	public void setRewardId(String rewardId) {
		this.rewardId = rewardId;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
}
