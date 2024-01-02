package az.developia.springjava13.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component(value = "employee2")
public class Employee {

	private Integer id;
	private String name;
	private Integer age;
	private Integer salary;
	@Autowired
	private Computer computer;
	
	public Employee() {
		this.id = 47;
		this.name = "Yusif";
		this.age = 31;
		this.salary = 100000;
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

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Computer getComputer() {
		return computer;
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	
	
}
