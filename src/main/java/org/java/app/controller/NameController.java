package org.java.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NameController {

	@GetMapping("/")
	@ResponseBody
	public String name() {
		
		return "Best of the year by ...";
	}
	
	@GetMapping("/best")
	public String best() {
		
		return "best";
	}
}
