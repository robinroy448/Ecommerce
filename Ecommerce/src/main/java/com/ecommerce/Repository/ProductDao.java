package com.ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.controller.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{

	public Product findById(int Id);
	
}
