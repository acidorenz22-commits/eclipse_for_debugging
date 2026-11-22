package com.pup.taguig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWebDit1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebDit1Application.class, args);
		
		User user = new User();
		user.code();	
	}

}
