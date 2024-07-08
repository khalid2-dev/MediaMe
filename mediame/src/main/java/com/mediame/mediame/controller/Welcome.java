package com.mediame.mediame.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/mediame")
public class Welcome {

	@GetMapping("/welcome")
	public String welcomeMSG() {
		return "Welcome to MEDIA ME app!";
	}
	
}
