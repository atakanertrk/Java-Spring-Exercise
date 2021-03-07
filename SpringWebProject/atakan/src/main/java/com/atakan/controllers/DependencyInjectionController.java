package com.atakan.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atakan.models.UserInfoModel;
import com.atakan.userservices.UserService;
import com.atakan.userservices.UserServiceImpl;
import com.atakan.userservices.UserServiceSecondImpl;

@RestController
@RequestMapping("/dependencyinjection")
public class DependencyInjectionController {
	
	private final UserService userService;
	public DependencyInjectionController() {
		this.userService = new UserServiceImpl();
	}
	
	@GetMapping(path="/createuser")
	public ResponseEntity<UserInfoModel> createUser(){
		var createdUser = userService.createUser("ata", "ert");
		return new ResponseEntity<UserInfoModel>(createdUser,HttpStatus.OK);
	}
	
}
