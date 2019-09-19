package com.junlaninfo.shiiroRealm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.Realm;
import org.springframework.beans.factory.annotation.Autowired;

import com.junlaninfo.entity.User;
import com.junlaninfo.service.UserService;

public class UserRealm  extends AuthenticatingRealm {
	@Autowired
	private UserService userService;

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		 //1、将token转化为UsernamePasswordtoken
		UsernamePasswordToken newtokPasswordToken=(UsernamePasswordToken) token;
		//2从token中取出userName
		String username = newtokPasswordToken.getUsername();
		User user = userService.login(username);
		SimpleAuthenticationInfo info=null;
		if(user!=null) {
			Object principal=username;
			Object credentials=user.getPassword();
			String realmName=this.getName();
			info=new SimpleAuthenticationInfo(principal, credentials, realmName);
		}
		
		return info;
	}

}
