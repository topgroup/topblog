package com.topblog.reaml;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.*;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.topblog.entity.UserInfo;
import com.topblog.service.UserInfoService;

public class LoginRealm extends AuthorizingRealm  {

	@Autowired
	UserInfoService userInfoService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		 return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		String username = String.valueOf(usernamePasswordToken.getUsername());
		UserInfo userInfo = userInfoService.getAllById(Integer.parseInt(username));
		
		if(userInfo == null){
			throw new UnknownAccountException();
		}
		
		String password = new String(usernamePasswordToken.getPassword());
		
		if (!password.equals(userInfo.getUsername())) {
			throw new IncorrectCredentialsException();
		}
		
		AuthenticationInfo authenticationInfo  = new SimpleAuthenticationInfo(userInfo.getUserid(), userInfo.getUsername(), getName());
		return authenticationInfo;
	}

}
