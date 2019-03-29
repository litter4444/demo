package com.dcl.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dcl.dao.UserDao;
import com.dcl.entity.User;
import com.dcl.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Override
	public User findById(Long id) {
		Optional<User> optional = userDao.findById(id);
		return optional.get();
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		userDao.deleteById(id);
	}

}
