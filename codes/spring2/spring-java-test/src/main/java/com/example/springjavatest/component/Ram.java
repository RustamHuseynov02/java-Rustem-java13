package com.example.springjavatest.component;

import org.springframework.stereotype.Component;

@Component
public class Ram {

	private String about;
	private Integer hz;
	
	public Ram () {
		this.about = "ddr3 12 gb ";
		this.hz = 5500;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public Integer getHz() {
		return hz;
	}

	public void setHz(Integer hz) {
		this.hz = hz;
	}
	
	
}
