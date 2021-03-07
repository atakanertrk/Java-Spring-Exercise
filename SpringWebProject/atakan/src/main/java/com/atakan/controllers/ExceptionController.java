package com.atakan.controllers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atakan.helpers.UserServiceException;

@RestController
@RequestMapping("/exception")
public class ExceptionController {
	
	@GetMapping(path="create")
	public ResponseEntity<Void> createException(){
		String x = null;
		x.length();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping(path="create2")
	public ResponseEntity<Void> createException2() {
		throw new UnsupportedOperationException("create2 ");
	}
	
	@GetMapping(path="create3")
	public ResponseEntity<Void> createException3() throws Exception{
		 try {
			String x = null;
			x.length();
		} catch (Exception e) {
			throw new Exception("create3 " ,e);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping(path="customexception")
	public ResponseEntity<Void> createCustomException(){
		throw new UserServiceException("user service exception is thrown");
	}
	@GetMapping(path="numberFormatException")
	public ResponseEntity<Void> createnumberFormatException(){
		 int a = Integer.parseInt(null);
		 return null;
	}
}
