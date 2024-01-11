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
		newPerson.setAge(20);
		newPerson.setName("Musa");
		return newPerson;
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
