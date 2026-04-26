package com.example.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UserController {

	
	@GetMapping("path")
	public String getMethodName(@RequestParam String param) {
		return new String();
	}
	
	@GetMapping("path")
	public String getMethodName1(@RequestParam String param) {
		return new String();
	}
	
	
}
