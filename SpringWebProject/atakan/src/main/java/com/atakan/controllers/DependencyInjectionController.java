package com.atakan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atakan.models.UserInfoModel;
import com.atakan.userservices.UserService;
import com.atakan.userservices.UserServiceBean;
import com.atakan.userservices.UserServiceImpl;
import com.atakan.userservices.UserServiceSecondImpl;

@RestController
@RequestMapping("/dependencyinjection")
public class DependencyInjectionController {
	
	@Autowired
	UserServiceBean userService;
	
	private final UserService userServiceConstructorImplementedVersion;
	public DependencyInjectionController() {
		this.userServiceConstructorImplementedVersion = new UserServiceImpl();
	}
	
	@GetMapping(path="/createfromconstructor")
	public ResponseEntity<UserInfoModel> createUserCtor(){
		var createdUser = userServiceConstructorImplementedVersion.createUser("ata", "ert");
		return new ResponseEntity<UserInfoModel>(createdUser,HttpStatus.OK);
	}
	@GetMapping(path="/createfromautowire1")
	public ResponseEntity<UserInfoModel> createUserAutowire1(){
		var createdUser = userService.createUserOne().createUser("ata", "ert");
		return new ResponseEntity<UserInfoModel>(createdUser,HttpStatus.OK);
	}
	@GetMapping(path="/createfromautowire2")
	public ResponseEntity<UserInfoModel> createUserAutowire2(){
		var createdUser = userService.createUserTwo().createUser("ata", "ert");
		return new ResponseEntity<UserInfoModel>(createdUser,HttpStatus.OK);
	}
}
