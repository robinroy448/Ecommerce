package com.ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.model.CurrentAdminSession;

public interface CurrentAdminSessionDao extends JpaRepository<CurrentAdminSession, Integer>{

}
