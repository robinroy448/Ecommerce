package com.ecommerce.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.stereotype.Service;

import com.ecommerce.Repository.AdminDao;
import com.ecommerce.Repository.CurrentAdminSessionDao;
import com.ecommerce.Repository.CurrentUserSessionDao;
import com.ecommerce.Repository.CustomerDao;
import com.ecommerce.dto.AdminLoginDto;
import com.ecommerce.dto.CustomerLoginDto;
import com.ecommerce.exception.AdminException;
import com.ecommerce.exception.CurrentAdminSessionException;
import com.ecommerce.exception.CurrentuserSessionException;
import com.ecommerce.exception.CustomerException;
import com.ecommerce.model.CurrentAdminSession;

import net.bytebuddy.utility.RandomString;

@Service
public class AdminLoginServiceImpl implements AdminLoginService{

	@Autowired
	private CurrentAdminSessionDao currentAdminSessionDao;
	@Autowired
	private AdminDao admindao;

	
	@Override
	public CurrentAdminSession loginAdmin(AdminLoginDto adminLoginDto) throws CurrentAdminSessionException, AdminException {

		com.ecommerce.model.Adminn ExistingAdmin = admindao.findByEmail(adminLoginDto.getEmail());

		if (ExistingAdmin != null) {

			if (ExistingAdmin.getPassword().equals(adminLoginDto.getPassword())) {

				String key = RandomString.make(6);

				CurrentAdminSession currentUserSession = new CurrentAdminSession(ExistingAdmin.getId(),
						LocalDateTime.now(), key);

				return currentAdminSessionDao.save(currentUserSession);
			} else {
				throw new CurrentAdminSessionException("Password Wrong");
			}
		}

		throw new AdminException("Please Enter a valid email");

	}

	@Override
	public String logoutAdmin(Integer id) throws CurrentAdminSessionException {

		Optional<CurrentAdminSession> loginCustomer = currentAdminSessionDao.findById(id);

		if (loginCustomer.isPresent()) {
			currentAdminSessionDao.delete(loginCustomer.get());
			
			return "User have been Logout";
			
		}
			
		throw new CurrentAdminSessionException("First login for logout ");
	}

	
}
