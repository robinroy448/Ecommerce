package com.ecommerce.service;

import com.ecommerce.exception.CustomerException;
import com.ecommerce.model.Customer;

public interface CustomerService {
	public Customer addCustomer(Customer customer) throws CustomerException;
	
	
	public Customer deleteCustomer(Customer customer) throws CustomerException;

}
