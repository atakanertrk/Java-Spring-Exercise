package com.atakan.userservices;

import org.springframework.stereotype.Service;

import com.atakan.models.UserInfoModel;

// UserServiceImplementation
public class UserServiceImpl implements UserService {

	@Override
	public UserInfoModel createUser(String name, String surname) {
		UserInfoModel user = new UserInfoModel();
		user.name = name;
		user.surname = surname;
		return user;
	}

}
