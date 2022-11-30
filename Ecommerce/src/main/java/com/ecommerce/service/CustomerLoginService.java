package com.ecommerce.service;

import com.ecommerce.dto.CustomerLoginDto;
import com.ecommerce.exception.CurrentuserSessionException;
import com.ecommerce.exception.CustomerException;
import com.ecommerce.model.CurrentUserSession;

public interface CustomerLoginService {
	
	
	public CurrentUserSession  loginCustomer(CustomerLoginDto loginDto) throws CurrentuserSessionException,CustomerException;
	
	public String logoutCoustomer(Integer id) throws CurrentuserSessionException;
	
	

}
