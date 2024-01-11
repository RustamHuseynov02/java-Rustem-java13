package com.example.springjavatest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerBook {

	@GetMapping(path = "/books")
	public String book() {
		return "books";
	}
}
