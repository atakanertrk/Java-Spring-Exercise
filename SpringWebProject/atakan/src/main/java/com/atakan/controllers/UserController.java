package com.atakan.controllers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atakan.models.UserInfoModel;
import com.sun.el.stream.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
	@GetMapping(path="getuser/asd{userId}")
	public String getUser(@PathVariable int userId) {
		return "get user was called by id of : " + userId;
	}
	@GetMapping(path="/getusers")
	public String getUsers(@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "10") int limit) {
		return page + " " + limit;
	}
	@GetMapping(path="/getunauthorized")
	public ResponseEntity<UserInfoModel> getUnauthorized() {
		var userInfoModel = new UserInfoModel();
		userInfoModel.name = "atakan"; userInfoModel.surname="erturk"; userInfoModel.id=2;
		return new ResponseEntity<UserInfoModel>(userInfoModel,HttpStatus.UNAUTHORIZED);
	}
	@PostMapping(path="/createuser")
	public ResponseEntity<String> createUser(@RequestBody UserInfoModel user) {
		String responseText = "created user with name : " + user.name + " and surname : " + user.surname + " id : " + 1;
		return new ResponseEntity<String>(responseText,HttpStatus.OK);
	}
	@PostMapping(path="sendidviaheader")
	public ResponseEntity<String> sendIdViaHeader(@RequestHeader("id") int id){
		return new ResponseEntity<String>(String.valueOf(id),HttpStatus.OK);
	}
	@PutMapping(path="/updateuserbyid")
	public ResponseEntity<String> updateUser(@RequestParam(required = true) int id) {
		String responseText = "update called by id : " + id;
		return new ResponseEntity<String>(responseText,HttpStatus.OK);
	}
	// this endpoint will be triggered if url looks like this : localhost:8080/users METHOD : DELETE
	@DeleteMapping(path="/delete")
	public String deleteUser() {
		return "deletedd";
	}
	@DeleteMapping(path="/deletenocontent")
	public ResponseEntity<Void> deleteUserNoContent(){
		return ResponseEntity.noContent().build();
	}
	@DeleteMapping(path="/deletenocontent2")
	public ResponseEntity<Void> deleteUserNoContent2(){
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
