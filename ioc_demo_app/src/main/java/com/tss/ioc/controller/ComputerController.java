package com.tss.ioc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tss.ioc.entity.Computer;

@RestController
@RequestMapping("/app")
public class ComputerController {

	@Autowired
	private Computer computer;
	
	@GetMapping("/computers")
	public Computer getComputer() {
		return computer;
	}
	
	@GetMapping("/computers/name")
	public String getComputerName() {
	    return computer.getName();
	}
}
