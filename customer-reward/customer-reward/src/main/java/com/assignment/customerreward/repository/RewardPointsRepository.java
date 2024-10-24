package com.assignment.customerreward.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.customerreward.entity.CustomerEntity;
import com.assignment.customerreward.entity.RewardPoints;

@Repository
public interface RewardPointsRepository extends JpaRepository<RewardPoints, String> {

	public List<RewardPoints> findByCustomer(CustomerEntity entity);
}
