package com.sayanpublic.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sayanpublic.helloworld.model.User;

@Controller
@ResponseBody
public class HomeController {

	@RequestMapping("/")
	public String home() {
		return "Hello World!";
	}

	// @RequestMapping(value = "/user", method = RequestMethod.GET)
	@GetMapping("/user")
	public User user() {
		User user = new User();
		user.setId("1");
		user.setName("UserA LNameA");
		user.setEmailId("userA@gmail.com");
		return user;
	}

	@GetMapping("/{id}/{id2}")
	public String pathVariable(@PathVariable("id") String firstVar, @PathVariable String id2) {
		return "The path-variable is: " + firstVar + "/" + id2;
	}

	@GetMapping("/requestParam")
	public String requestParam(@RequestParam String name, 
							   @RequestParam(name = "email", required = false, defaultValue = "") String emailId) {
		return "Your name is: " + name + " and emailId is: " + emailId;
	}
}
