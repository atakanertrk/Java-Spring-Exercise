package com.atakan.userservices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserServiceBean {

	@Bean(name="userServiceOne")
	public UserService createUserOne() {
		return new UserServiceImpl();
	}
	
	@Bean(name="userServiceTwo")
	public UserService createUserTwo() {
		return new UserServiceSecondImpl();
	}
	
}
