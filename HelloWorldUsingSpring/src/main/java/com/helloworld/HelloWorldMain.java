package com.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldMain {
	
	@RequestMapping(value="/")
	
	/*
	 * Legacy approach:
	 * HelloWorldMain obj=new HelloWorldMain();
	 * obj.getHelloWorld(); 
	 */
	
	public String getHelloWorld() {
		return "Welcome to SpringBoot using Spring Approach";
	}
}
