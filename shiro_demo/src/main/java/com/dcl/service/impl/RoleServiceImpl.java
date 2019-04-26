package com.dcl.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcl.dao.RoleDao;
import com.dcl.entity.Role;
import com.dcl.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDao roleDao;


	@Override
	public List<Role> getByIds(String[] ids) {
		// TODO Auto-generated method stub
		return roleDao.getByIds(ids);
	}

}
