package com.assignment.customerreward.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.customerreward.entity.CustomerTransaction;

@Repository
public interface CustomerTransactionRepository extends JpaRepository<CustomerTransaction, String> {

}
