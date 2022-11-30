package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.exception.AdminException;
import com.ecommerce.model.Adminn;
import com.ecommerce.service.AdminService;

@RestController
public class AdminController {


		@Autowired
		private AdminService adminService;
		
		@PostMapping("/addAdmin")
		public ResponseEntity<Adminn> addCustomer(@RequestBody() Adminn admin) throws AdminException{
			
			Adminn admin2 = adminService.addAdmin(admin);
			
			return new ResponseEntity<Adminn>(admin2,HttpStatus.ACCEPTED);
		}
		
		
		@DeleteMapping("/deleteAdmin")
		public ResponseEntity<Adminn> deleteCustomer(@RequestBody() Adminn admin) throws AdminException{
			
			Adminn admin2 = adminService.deleteAdmin(admin);
			
			return new ResponseEntity<Adminn>(admin2,HttpStatus.ACCEPTED);
		}
}
