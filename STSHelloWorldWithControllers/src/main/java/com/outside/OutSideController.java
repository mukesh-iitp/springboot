package com.outside;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/outside")
public class OutSideController {
	
	@RequestMapping(value="/method1") //http://localhost:8080/outside/mehtod1
	public String callOutside() {
		return "Out side of BootStrap Class";
	}
	

}
