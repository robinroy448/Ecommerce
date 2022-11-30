package com.ecommerce.service;

import com.ecommerce.dto.AdminLoginDto;
import com.ecommerce.dto.CustomerLoginDto;
import com.ecommerce.exception.AdminException;
import com.ecommerce.exception.CurrentAdminSessionException;
import com.ecommerce.exception.CurrentuserSessionException;
import com.ecommerce.model.CurrentAdminSession;
import com.ecommerce.model.CurrentUserSession;

public interface AdminLoginService {
	public CurrentAdminSession loginAdmin(AdminLoginDto adminLoginDto)
			throws CurrentAdminSessionException, AdminException;

	public String logoutAdmin(Integer id) throws CurrentAdminSessionException;
}
