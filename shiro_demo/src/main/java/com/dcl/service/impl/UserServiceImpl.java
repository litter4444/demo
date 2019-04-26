package com.dcl.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcl.dao.UserDao;
import com.dcl.entity.User;
import com.dcl.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public User getByUsername(String username) {
		return userDao.getByUsername(username);
	}

	@Override
	public Set<String> getUserRoles(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
