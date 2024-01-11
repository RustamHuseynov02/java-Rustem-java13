package com.example.springjavatest.component;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Scope("prototype")
public class Home {

	private Integer id;
	private String address;
	private String color;
	
	public Home() {
		this.id = 2121;
		this.address = "sumqayit 10 mkr hiperin arxasi";
		this.color = "brown";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("her sey hazir olduqdan sonra ilk olaraq men calisacam");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("bean yasam dovrunde en sona geldikde yeni omuru bitmemisden evvel calisir sonra omru bitir gedir");
	}
}
