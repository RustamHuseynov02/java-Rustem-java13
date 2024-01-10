package com.example.springjavatest.component;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class Example {

	@Bean
	public Person examplePerson() {
		Person newPerson = new Person();
		System.out.println(newPerson.getName());
		System.out.println(newPerson.getAge());
		return newPerson;
	}

	@Bean
	public Dependency exampleDependency() {
		Dependency dependency1 = new Dependency();
		dependency1.setName("2 ci Bean dependencyden");
		return dependency1;
	}
	
	@Bean
	public Computer myComp() {
		Computer computer1 = new Computer();
		computer1.setId(1111);
		computer1.setBrand("Acer");
		computer1.setPrice(22211);
		computer1.setModel("Gaming");
		return computer1;
	}

	@Bean
	public Ram compRam() {
		Ram ddr2 = new Ram();
		ddr2.setAbout("ddr2 8gb");
		ddr2.setHz(2000);
		return ddr2;
	}
}
