package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dto.AdminLoginDto;
import com.ecommerce.dto.CustomerLoginDto;
import com.ecommerce.exception.AdminException;
import com.ecommerce.exception.CurrentAdminSessionException;
import com.ecommerce.exception.CurrentuserSessionException;
import com.ecommerce.exception.CustomerException;
import com.ecommerce.model.CurrentAdminSession;
import com.ecommerce.model.CurrentAdminSession;
import com.ecommerce.service.AdminLoginService;
import com.ecommerce.service.AdminService;
import com.ecommerce.service.CustomerLoginService;

@RestController
public class AdminLoginLogoutController {

	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private AdminLoginService adminLoginService;
	
	@PostMapping("/loginAdmin")
	public ResponseEntity<CurrentAdminSession> LoginAdmin(@RequestBody  AdminLoginDto adminLoginDto) throws  CurrentAdminSessionException, AdminException{
		
		CurrentAdminSession currentAdminSession = adminLoginService.loginAdmin(adminLoginDto);
		
		
		
		return new ResponseEntity<CurrentAdminSession>(currentAdminSession,HttpStatus.ACCEPTED);
		
		
		
	}
	
	
	@PostMapping("/logoutAdmin")
	public ResponseEntity<String> LogoutAdmin(@RequestParam("id") Integer id) throws CurrentAdminSessionException{
		
		String  logout = adminLoginService.logoutAdmin(id);
		
		
		
		return new ResponseEntity<String>(logout,HttpStatus.ACCEPTED);
		
		
		
	}
}
