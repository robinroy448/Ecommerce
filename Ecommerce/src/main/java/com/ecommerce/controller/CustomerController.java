package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.exception.CustomerException;
import com.ecommerce.model.Customer;
import com.ecommerce.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody() Customer customer) throws CustomerException{
		
		Customer customer2 = customerService.addCustomer(customer);
		
		return new ResponseEntity<Customer>(customer2,HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/deleteCustomer")
	public ResponseEntity<Customer> deleteCustomer(@RequestBody() Customer customer) throws CustomerException{
		
		Customer customer2 = customerService.deleteCustomer(customer);
		
		return new ResponseEntity<Customer>(customer2,HttpStatus.ACCEPTED);
	}
	
	
}
