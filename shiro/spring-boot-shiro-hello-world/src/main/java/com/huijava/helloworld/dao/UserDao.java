/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.huijava.helloworld.dao;

import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

/**
 * 模拟从数据库中获取用户信息
 *
 * @author chenhx
 * @version UserDao.java, v 0.1 2018-08-02 下午 4:55
 */
@Repository
public class UserDao {

    /**
     * 通过用户名获取用户的所有角色名
     *
     * @param username
     * @return
     */
    public Set<String> selectRolesByUsername(String username) {
        Set<String> roles = new HashSet<String>();
        if (username=="chenhx") {
        	roles.add("admin");
		}
       if (username=="user") {
    	    roles.add("user");
	}
            
        return roles;
    }

    /**
     * 通过角色名获取权限
     *
     * @param role
     * @return
     */
    public Set<String> selectPermissionsByRole(String role) {
        Set<String> permissions = new HashSet<String>();
        if (role=="admin") {
        	  permissions.add("user:*");
		}
        if (role=="user") {
			 permissions.add("user:insert");
             permissions.add("user:select");
		}
        return permissions;
    }

    /**
     * 用户进行登录
     *
     * @param username
     * @return
     */
    public String selectPasswordByUsername(String username) {
        if (username=="chenhx" ||username=="user") {
        	 return "1234";
		}
    	
    	
        return null;
    }

}