package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Repository.AdminDao;
import com.ecommerce.exception.AdminException;
import com.ecommerce.model.Adminn;


@Service
public class AdminServiceImpl implements AdminService{

	
	@Autowired
	private AdminDao adminDao;

	@Override
	public Adminn addAdmin(Adminn admin) throws AdminException {
		Adminn cus = adminDao.findByEmail(admin.getEmail());
		Adminn cus1 = null;
		
		
		if(cus==null) {
		 cus1 = adminDao.save(admin);
		 return cus1;
		}
		
		throw new AdminException("Admin already exist with this email");
	}

	@Override
	public Adminn deleteAdmin(Adminn admin) throws AdminException {
		Adminn cus = adminDao.findByEmail(admin.getEmail());
		Adminn cus1 = null;
		
		
		if(cus!=null) {
		 adminDao.delete(admin);
		 
		 return admin;
		}
		throw new AdminException("Admin does not exist");

	}
	
	

	
}
