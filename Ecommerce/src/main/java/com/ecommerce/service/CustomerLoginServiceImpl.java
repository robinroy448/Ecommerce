package com.ecommerce.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Repository.CurrentUserSessionDao;
import com.ecommerce.Repository.CustomerDao;
import com.ecommerce.dto.CustomerLoginDto;
import com.ecommerce.exception.CurrentuserSessionException;
import com.ecommerce.exception.CustomerException;
import com.ecommerce.model.CurrentUserSession;
import com.ecommerce.model.Customer;

import net.bytebuddy.utility.RandomString;

@Service
public class CustomerLoginServiceImpl implements CustomerLoginService {
	@Autowired
	private CurrentUserSessionDao currentUserSessionDao;
	@Autowired
	private CustomerDao customerDao;

	@Override
	public CurrentUserSession loginCustomer(CustomerLoginDto loginDto) throws CurrentuserSessionException, CustomerException {

		Customer ExistingCustomer = customerDao.findByEmail(loginDto.getEmail());

		if (ExistingCustomer != null) {

			if (ExistingCustomer.getPassword().equals(loginDto.getPassword())) {

				String key = RandomString.make(6);

				CurrentUserSession currentUserSession = new CurrentUserSession(ExistingCustomer.getId(),
						LocalDateTime.now(), key);

				return currentUserSessionDao.save(currentUserSession);
			} else {
				throw new CurrentuserSessionException("Password Wrong");
			}
		}

		throw new CustomerException("Please Enter a valid email");

	}

	@Override
	public String logoutCoustomer(Integer id) throws CurrentuserSessionException {

		Optional<CurrentUserSession> loginCustomer = currentUserSessionDao.findById(id);

		if (loginCustomer.isPresent()) {
			currentUserSessionDao.delete(loginCustomer.get());
			
			return "User have been Logout";
			
		}
			
		throw new CurrentuserSessionException("First login for logout ");
	}

}












































