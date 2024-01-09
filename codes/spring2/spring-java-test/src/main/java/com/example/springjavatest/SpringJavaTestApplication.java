package com.example.springjavatest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.springjavatest.component.Book;
import com.example.springjavatest.component.Person;

@SpringBootApplication
public class SpringJavaTestApplication {

	public static void main(String[] args) {
	    ConfigurableApplicationContext context = SpringApplication.run(SpringJavaTestApplication.class, args);
	    
	    Person persons = context.getBean("examplePerson", Person.class);
	    System.out.println(persons.getId());
	    System.out.println(persons.getName());
	    System.out.println(persons.getAge());
	    System.out.println(persons.getSalary());
	    
	    
	    System.out.println("---------------------");
	    
	    Book theBook = context.getBean(Book.class);
	    System.out.println(theBook.getId());
	    System.out.println(theBook.getName());
	    System.out.println(theBook.getPrice());
	    System.out.println(theBook.getPageCount());
	    
	    
	    
//	    String [] a = context.getBeanDefinitionNames();
//	    for (String beanNames : a) {
//			System.out.println(beanNames);
//		}
	}

}
