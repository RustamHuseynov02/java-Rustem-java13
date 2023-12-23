package az.developia.springjava13;

import org.springframework.stereotype.Component;

@Component
public class Person {

	private Integer id;
	private String name;
	private Integer age;
	private Double salary;
	
	public Person() {
		this.id = 1;
		this.name = "Rustem";
		this.age = 21;
		this.salary  = 3000.50;
		
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	
}
