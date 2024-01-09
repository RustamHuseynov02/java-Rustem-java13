package com.example.springjavatest.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Example {

	
	@Bean
	public Person examplePerson() {
		Person newPerson = new Person();
		System.out.println(newPerson.getName());
		System.out.println(newPerson.getAge());
		return newPerson;
	}
	
}
