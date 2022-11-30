package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dto.CustomerLoginDto;
import com.ecommerce.exception.CurrentuserSessionException;
import com.ecommerce.exception.CustomerException;
import com.ecommerce.model.CurrentUserSession;
import com.ecommerce.service.CustomerLoginService;

@RestController
public class CustomerLoginLogoutController {

	@Autowired
	private CustomerLoginService customerLoginService;
	
	@PostMapping("/loginCustomer")
	public ResponseEntity<CurrentUserSession> LoginCustomer(@RequestBody  CustomerLoginDto loginDto) throws CurrentuserSessionException, CustomerException{
		
		CurrentUserSession currentUserSession = customerLoginService.loginCustomer(loginDto);	
		
		
		return new ResponseEntity<CurrentUserSession>(currentUserSession,HttpStatus.ACCEPTED);
		
		
		
	}
	
	
	@PostMapping("/logoutCustomer")
	public ResponseEntity<String> LogoutCustomer(@RequestParam("id") Integer id) throws CurrentuserSessionException{
		
		String  logout = customerLoginService.logoutCoustomer(id);
		
		
		
		return new ResponseEntity<String>(logout,HttpStatus.ACCEPTED);
		
		
		
	}
}
