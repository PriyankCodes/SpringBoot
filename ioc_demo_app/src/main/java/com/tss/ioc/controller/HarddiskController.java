package com.tss.ioc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tss.ioc.entity.Harddisk;

@RestController
@RequestMapping("/app")
public class HarddiskController {
	
	@Autowired
	private Harddisk harddisk;
	
	@GetMapping("/harddisks")
	public Harddisk getHarddisk() {
		return harddisk;
	}
	
	@GetMapping("/harddisks/capacity")
	public Integer getHarddiskCapacity() {
	    return harddisk.getCapacity();
	}


}
