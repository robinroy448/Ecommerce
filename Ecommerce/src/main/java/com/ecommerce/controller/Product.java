package com.ecommerce.controller;


import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	private Integer productId;
	private String productName;
	private String Category;
	private String quantity;
	private Integer price;

}
