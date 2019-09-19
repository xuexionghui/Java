package com.junlaninfo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.junlaninfo.entity.User;
import com.junlaninfo.service.UserService;

@Controller
public class loginController {
	@Autowired
	private UserService  userService;
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	 public String  login(@RequestParam("username") String  username,
			 @RequestParam("password") String password) {
		 //User user=userService.login(username,password);
		Subject subject = SecurityUtils.getSubject();
		if(subject.isAuthenticated()==false) {
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			try {
				subject.login(token);
			} catch (AuthenticationException e) {
				return "fail";
			}
			
		}
		
       	return "success";
	}
}
