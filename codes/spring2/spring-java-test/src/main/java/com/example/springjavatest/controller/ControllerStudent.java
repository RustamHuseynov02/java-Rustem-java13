package com.example.springjavatest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerStudent {

	@GetMapping(path = "/students")
	public String student() {
		return "students";
	}
}
