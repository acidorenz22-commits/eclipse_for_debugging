package com.pup.taguig.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	
	public String getUser() {
		return "Sample Return";
	}
	
	public String getUserStatus() {
		return "User Status" ;
	}

}
