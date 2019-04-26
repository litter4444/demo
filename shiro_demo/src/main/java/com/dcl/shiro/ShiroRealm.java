package com.dcl.shiro;

import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dcl.dao.ResourceDao;
import com.dcl.dao.RoleDao;
import com.dcl.dao.UserDao;
import com.dcl.entity.Role;
import com.dcl.entity.User;

@Component
public class ShiroRealm extends AuthorizingRealm {
	@Autowired
	private ResourceDao resourceDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;

	
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		String username = (String)principals.getPrimaryPrincipal();
		//查询当前用户
		User user = userDao.getByUsername(username);
		//查询用户角色
		String roleIds = user.getRoleIds();
		String[] ids = roleIds.split(",");
		List<Role> roles = roleDao.getByIds(ids);
		for (Role role : roles) {
			//添加角色
			authorizationInfo.addRole(role.getName());
			String resourceIds = role.getResourceIds();
			String[] split = resourceIds.split(",");
			//查询用户权限
			Set<String> permissions = resourceDao.getPermissionsByIds(split);
			authorizationInfo.addStringPermissions(permissions);
		}
		return authorizationInfo;
	}

	/**
	 * 登录
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)token;
		String username = usernamePasswordToken.getUsername();
		User user = userDao.getByUsername(username);
		if(user == null) {
			return null;
		}else {
			//校验密码
			return new SimpleAuthenticationInfo(username,user.getPassword(),ByteSource.Util.bytes(username.getBytes()),getName());
		}
	}

}
