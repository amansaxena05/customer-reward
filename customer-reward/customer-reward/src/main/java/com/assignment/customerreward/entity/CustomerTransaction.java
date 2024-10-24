package com.assignment.customerreward.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer_transaction")
public class CustomerTransaction {
	
	@Id
	@Column(name = "id")
	private String transactionId;

	@Column(name = "transaction_date")
	private LocalDate date;
	
	@Column(name = "amount")
	private int amount;
	
	@Column(name = "spent_details")
	private String spentDetails;
	
	@OneToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private CustomerEntity customer;

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

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}
	
}
