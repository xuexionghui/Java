package com.junlaninfo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junlaninfo.entity.User;
import com.junlaninfo.service.UserService;
import com.junlaninfo.service.dao.UserDao;

@Service
public class UserServiceImpl  implements UserService{
    
	@Autowired
	private UserDao userDao;
	@Override
	public User login(String username) {
		 return userDao.login(username);
		
	}

}
