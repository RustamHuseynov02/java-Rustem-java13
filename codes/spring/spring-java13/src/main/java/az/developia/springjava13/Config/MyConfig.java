package az.developia.springjava13.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import az.developia.springjava13.component.Employee;
import az.developia.springjava13.component.Computer;
import az.developia.springjava13.component.Ram;

@Configuration
public class MyConfig {

	@Bean
	public Employee employee() {
		Employee employees = new Employee();
		employees.setId(45);
		employees.setName("Rustem");
		employees.setAge(21);
		employees.setSalary(11111);
		return employees;
	}
	
	@Bean
	public Computer myComp() {
		Computer computer = new Computer();
		computer.setId(155);
		computer.setBrand("Toshiba");
		computer.setPrice(2000);
		computer.setColor("white");
		return computer;
	}
	
	@Bean
	public Ram ramMemory() {
		Ram ram = new Ram();
		ram.setMemory(12);
		ram.setMhz("7000mhz");
		return ram;
	}
}
