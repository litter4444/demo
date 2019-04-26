package com.dcl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.dcl.entity.Role;

public interface RoleDao {
//	@Select("select name from sys_role where id in(#{roleIds})")
	@Select({
		"<script>",
		"select name,resource_ids from sys_role where id in",
		"<foreach collection='array' item='id' open='(' close=')' separator=','>",
		"#{id}",
		"</foreach>",
		"</script>"
	})
	@Results(id="roleResultMap",value={
		@Result(column="resource_ids",property="resourceIds")
	})
	List<Role> getByIds(String[] ids);
}
