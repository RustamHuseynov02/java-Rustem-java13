package az.developia.springjava13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import az.developia.springjava13.component.Employee;
import az.developia.springjava13.component.Ram;
import az.developia.springjava13.component.Book;
import az.developia.springjava13.component.Computer;
import az.developia.springjava13.component.Home;
import az.developia.springjava13.component.Student;

@SpringBootApplication
public class SpringJava13Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringJava13Application.class, args);
		
//		Book books = context.getBean(Book.class);
//		System.out.println(books.getId());
//		System.out.println(books.getName());
//		System.out.println(books.getPrice());
//		System.out.println(books.getPageCount());
//		
//		System.out.println("-----------------");
//		
//		Person persons = context.getBean(Person.class);
//		System.out.println(persons.getId());
//		System.out.println(persons.getName());
//		System.out.println(persons.getAge());
//		System.out.println(persons.getSalary());
//		
//		System.out.println("-----------------");
//		
//		
//		Computer computer = context.getBean("myComp",Computer.class);
//		System.out.println(computer.getId());
//		System.out.println(computer.getBrand());
//		System.out.println(computer.getPrice());
//		System.out.println(computer.getColor());
//		System.out.println(computer.getRam().getMemory());
//		
//		
//		System.out.println("-----------------");
//
//		Employee employees = context.getBean("employee2", Employee.class);
//		System.out.println(employees.getId());
//		System.out.println(employees.getName());
//		System.out.println(employees.getAge());
//		System.out.println(employees.getSalary());
//		System.out.println(employees.getComputer().getBrand());
//		
//		System.out.println("-----------------");
//		
//		
//		Home home = context.getBean(Home.class);
//		System.out.println(home.getId());
//		System.out.println(home.getAddress());
//		System.out.println(home.getColor());
//		
//		System.out.println("-----------------");
//		
//		Home home1 = context.getBean(Home.class);
//		System.out.println(home.getId());
//		System.out.println(home.getAddress());
//		System.out.println(home.getColor());
		
		
		
		
		
//		String[] beanNames = context.getBeanDefinitionNames();
//		for (String beanName : beanNames) {
//			System.out.println(beanName);
//		}
	}

}
