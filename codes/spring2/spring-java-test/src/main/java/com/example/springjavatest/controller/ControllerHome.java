package com.example.springjavatest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerHome {

	@GetMapping
	public String Home() {
		return "home";
	}
}
