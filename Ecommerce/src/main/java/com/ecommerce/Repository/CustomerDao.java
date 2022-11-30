package com.ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.model.Customer;

public interface CustomerDao extends JpaRepository<Customer,Integer> {

	public Customer findByEmail(String email);
}
