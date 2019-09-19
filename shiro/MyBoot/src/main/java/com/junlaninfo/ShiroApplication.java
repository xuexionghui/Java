package com.junlaninfo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.junlaninfo.service.dao")
public class ShiroApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(ShiroApplication.class);
		application.run(args);

	}

}
