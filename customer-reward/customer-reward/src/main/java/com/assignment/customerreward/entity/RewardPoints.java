package com.assignment.customerreward.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reward_points")
public class RewardPoints {

	@Id
	@Column(name = "id")
	private String rewardId;
	
	@Column(name = "transaction_month")
	private int month;
	
	@Column(name = "transaction_year")
	private int year;
	
	@Column(name = "points")
	private int points;
	
	@OneToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private CustomerEntity customer;

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

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}
	
}
