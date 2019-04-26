package com.dcl.service;

import java.util.Set;

import com.dcl.entity.User;

public interface UserService {
	User getByUsername(String username);
	Set<String> getUserRoles(String username);
}
