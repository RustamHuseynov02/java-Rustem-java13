package com.example.springjavatest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.springjavatest.component.Book;
import com.example.springjavatest.component.Computer;
import com.example.springjavatest.component.Home;
import com.example.springjavatest.component.Person;


@SpringBootApplication
public class SpringJavaTestApplication {

	public static void main(String[] args) {
	    ConfigurableApplicationContext context = SpringApplication.run(SpringJavaTestApplication.class, args);
	    
//	    Person persons = context.getBean(Person.class);
//	    System.out.println(persons.getId());
//	    System.out.println(persons.getName());
//	    System.out.println(persons.getAge());
//	    System.out.println(persons.getSalary());
//	    System.out.println(persons.getComputer().getRam().getAbout());    // bunun adi oldu injection bu biraz extends animsatir.
//	    
//	    
//	    
//	    System.out.println("---------------------");
//	    
//	    Book theBook = context.getBean(Book.class);
//	    System.out.println(theBook.getId());
//	    System.out.println(theBook.getName());
//	    System.out.println(theBook.getPrice());
//	    System.out.println(theBook.getPageCount());
//	    
//	    
//	    System.out.println("---------------------");
//	    
//	    Computer computer = context.getBean("computer", Computer.class);
//	    System.out.println(computer.getId());
//	    System.out.println(computer.getBrand());
//	    System.out.println(computer.getPrice());
//	    System.out.println(computer.getModel());
//	    System.out.println(computer.getRam().getAbout());
//	    
//	    System.out.println("---------------------");
//	    Home home = context.getBean(Home.class);
//	    System.out.println(home.getId());
//	    System.out.println(home.getAddress());
//	    System.out.println(home.getColor());
//	    
//	    
//	    System.out.println("---------------------");
//	    Home myHome = context.getBean(Home.class);
//	    System.out.println(myHome.getId());
//	    System.out.println(myHome.getAddress());
//	    System.out.println(myHome.getColor());
//	    
//	    System.out.println("---------------------");
	    
//	    String [] a = context.getBeanDefinitionNames();
//	    for (String beanNames : a) {
//			System.out.println(beanNames);
//		}
	}

}
