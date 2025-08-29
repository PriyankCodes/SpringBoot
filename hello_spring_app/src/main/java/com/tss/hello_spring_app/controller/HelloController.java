package com.tss.hello_spring_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/sayHello")
	public String displayHello() {
		return "Hello to Springboot Application";
	}
	
	@GetMapping("/sayBye")
	public String displayye() {
		return "Tata Bye Bye";
	}

}
