package com.dcl.service;

import com.dcl.entity.User;

public interface UserService {
	User findById(Long id);
	void deleteById(Long id);
}
