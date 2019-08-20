package com.youfan.service.impl;

import com.youfan.service.SayHelloService;

public class SayHelloServiceImpl implements SayHelloService{

	public String sayhello(String name) {
		return "hello--"+name;
	}

}
