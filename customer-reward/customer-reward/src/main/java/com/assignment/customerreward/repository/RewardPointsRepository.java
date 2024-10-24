package com.assignment.customerreward.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.customerreward.entity.CustomerEntity;
import com.assignment.customerreward.entity.RewardPoints;

/**
 * RewardPointsRepository for RewardPoints table
 * @author aman.saxena05
 *
 */
@Repository
public interface RewardPointsRepository extends JpaRepository<RewardPoints, String> {

	/**
	 * repository method to find RewardPoints findByCustomer 
	 * @param entity
	 * @return
	 */
	public List<RewardPoints> findByCustomer(CustomerEntity entity);
}
