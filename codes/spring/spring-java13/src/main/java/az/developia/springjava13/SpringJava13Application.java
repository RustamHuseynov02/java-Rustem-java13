package az.developia.springjava13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringJava13Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringJava13Application.class, args);
		
		Book books = context.getBean(Book.class);
		System.out.println(books.getId());
		System.out.println(books.getName());
		System.out.println(books.getPrice());
		System.out.println(books.getPageCount());
		
		System.out.println("-----------------");
		
		Person persons = context.getBean(Person.class);
		System.out.println(persons.getId());
		System.out.println(persons.getName());
		System.out.println(persons.getAge());
		System.out.println(persons.getSalary());
		
		
		String[] beanNames = context.getBeanDefinitionNames();
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
	}

}
