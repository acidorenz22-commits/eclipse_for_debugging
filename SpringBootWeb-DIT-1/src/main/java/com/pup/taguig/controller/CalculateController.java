package com.pup.taguig.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate")

public class CalculateController {

	@GetMapping
	public double calculate(
			@RequestParam int num1, 
			@RequestParam int num2, 
			@RequestParam String operation ) {
		
		if (operation.equalsIgnoreCase("add")) {
			return num1 + num2;
		} else if (operation.equalsIgnoreCase("subtraction")) {
			return num1 - num2;
		} else if (operation.equalsIgnoreCase("multiply")) {
			return num1 * num2;
		}else if (operation.equalsIgnoreCase("divide")) {
			return num1 / num2;
		}	 	
		return 0;
	}
	
}
