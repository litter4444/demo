package com.dcl;

import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.dcl.dao.ResourceDao;
import com.dcl.dao.RoleDao;
import com.dcl.dao.UserDao;
import com.dcl.entity.Role;
import com.dcl.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MqBootDemo1ApplicationTests {

	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private ResourceDao resourceDao;
	@Autowired
	private DataSource dataSource;
	@Autowired
	private CacheManager cacheManager;
	@Test
	public void contextLoads() {
	}
	@Test
	public void testFindByUsername() {
		User user = userDao.getByUsername("admin");
		System.err.println(user);
	}
	@Test
	public void testGetByIds() {
		String[] ids=new String[] {"1","2"};
		List<Role> byIds = roleDao.getByIds(ids);
		System.err.println(byIds);
	}
	@Test
	public void testGetPermissions() {
		String[] ids=new String[] {"11","21","31","41"};
		Set<String> byIds = resourceDao.getPermissionsByIds(ids);
		System.err.println(byIds);
	}
	@Test
	public void testDependency() {
		System.err.println(cacheManager.getClass().getName());
		System.err.println(dataSource.getClass().getName());
		
	}

}
