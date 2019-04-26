package com.dcl.service;

import java.util.List;

import com.dcl.entity.Role;

public interface RoleService {
	/**
	 * 根据id查询角色名称列表
	 * @param ids
	 * @return
	 */
	List<Role> getByIds(String[] ids);
}
