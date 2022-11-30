package com.ecommerce.service;

import com.ecommerce.exception.AdminException;
import com.ecommerce.model.Adminn;

public interface AdminService {

public Adminn addAdmin(Adminn admin) throws AdminException;
	
	
	public Adminn deleteAdmin(Adminn admin) throws AdminException;
}
