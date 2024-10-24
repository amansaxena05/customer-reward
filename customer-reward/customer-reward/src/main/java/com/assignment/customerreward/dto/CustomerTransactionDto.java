package com.assignment.customerreward.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

/**
 * CustomerTransactionDto to be accepted and send in request and response
 * @author aman.saxena05
 *
 */
public class CustomerTransactionDto {

	private String transactionId;
	
	private LocalDate date;
	
	private int amount;
	
	private String spentDetails;
	
	@NotNull(message = "customerId should be present in transaction")
	private String customerId;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getSpentDetails() {
		return spentDetails;
	}

	public void setSpentDetails(String spentDetails) {
		this.spentDetails = spentDetails;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "CustomerTransactionDto [transactionId=" + transactionId + ", date=" + date + ", amount=" + amount
				+ ", spentDetails=" + spentDetails + ", customerId=" + customerId + "]";
	}

}
