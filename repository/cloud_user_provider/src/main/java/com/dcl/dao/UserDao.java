package com.dcl.dao;

import org.springframework.data.repository.CrudRepository;

import com.dcl.entity.User;

public interface UserDao extends CrudRepository<User, Long> {
	
}
