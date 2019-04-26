package com.dcl.dao;

import java.util.Set;

import org.apache.ibatis.annotations.Select;

import com.dcl.entity.User;

public interface UserDao {
	/**
	 * 通过username查询User
	 * @param username
	 * @return
	 */
	@Select("select * from sys_user where username=#{username}")
	User getByUsername(String username);
	
	@Select("select ")
	Set<String> getUserRoles(String username);
}
