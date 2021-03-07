package com.atakan.userservices;

import com.atakan.models.UserInfoModel;

public interface UserService {
	UserInfoModel createUser(String name, String surname);
}
