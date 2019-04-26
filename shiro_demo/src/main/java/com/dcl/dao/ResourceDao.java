package com.dcl.dao;

import java.util.Set;

import org.apache.ibatis.annotations.Select;

public interface ResourceDao {
	@Select({
		"<script>",
		"select permission from sys_resource where id in",
		"<foreach collection='array' item='id' open='(' close=')' separator=','>",
		"#{id}",
		"</foreach>",
		"</script>"
	})
	Set<String> getPermissionsByIds(String[] ids);
}
