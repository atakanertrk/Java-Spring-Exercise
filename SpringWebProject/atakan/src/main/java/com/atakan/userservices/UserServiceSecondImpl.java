package com.atakan.userservices;

import org.springframework.stereotype.Service;

import com.atakan.models.UserInfoModel;

//UserServiceSecondImplementation
public class UserServiceSecondImpl implements UserService {

	@Override
	public UserInfoModel createUser(String name, String surname) {
		UserInfoModel user = new UserInfoModel();
		user.name = name+" 2";
		user.surname = surname+" 2";
		return user;
	}

}
