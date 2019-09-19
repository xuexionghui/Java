/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.huijava.helloworld.entity;

import lombok.Data;

/**
 * 用户实体类
 *
 * @author chenhx
 * @version Users.java, v 0.1 2018-08-02 下午 5:13
 */
@Data
public class Users {
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private Integer id;
    private String username;
    private String password;
}