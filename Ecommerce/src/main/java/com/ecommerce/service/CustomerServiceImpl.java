package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Repository.CustomerDao;
import com.ecommerce.exception.CustomerException;
import com.ecommerce.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;

	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {
		Customer cus = customerDao.findByEmail(customer.getEmail());
		Customer cus1 = null;
		
		
		if(cus==null) {
		 cus1 = customerDao.save(customer);
		 return cus1;
		}
		
		throw new CustomerException("Customer already exist with this email");
	}

	@Override
	public Customer deleteCustomer(Customer customer) throws CustomerException {
		Customer cus = customerDao.findByEmail(customer.getEmail());
		Customer cus1 = null;
		
		
		if(cus!=null) {
		 customerDao.delete(customer);
		 
		 return customer;
		}
		throw new CustomerException("Customer does not exist");

	}
	
	

}
