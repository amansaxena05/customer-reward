package com.assignment.customerreward.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.customerreward.entity.CustomerEntity;

/**
 * CustomerRepository
 * @author aman.saxena05
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {

}
