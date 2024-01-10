package com.example.springjavatest.component;

import org.springframework.stereotype.Component;

@Component
public class Dependency {

	private Integer id;
	private String name;
	
	public Dependency() {
		this.id = 321;
		this.name = "Asilliq";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
