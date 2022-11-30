package com.ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.model.Adminn;


public interface AdminDao extends JpaRepository<Adminn,Integer>{
	public Adminn findByEmail(String email);
}
