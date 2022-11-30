package com.ecommerce.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;




@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private Integer id;
	
	private String name;
	private String email;
	private String address;
	private String password;
	private String phone;	

}
