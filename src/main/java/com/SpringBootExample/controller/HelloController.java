package com.SpringBootExample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;



////@RestController  :latest and it has the response body that every controller need it
//@Controller //old style 
@RestController 
public class HelloController {
	
	/*
	 * from the properties file, we need to used the welcome.message here so for that,
	 * we need to create the property here "private String welcomeMessage" 
	 * and add the annotation @Value  
	 */
	
	@Value("${welcome.message}") //this fetch from the properties file
	private String welcomeMessage;
	
	//@RequestMapping(value = "/", method = RequestMethod.GET) //this line is verbose 
	 @GetMapping("/welcome")
	public String welcom() {
		
		return welcomeMessage;

	}

}
