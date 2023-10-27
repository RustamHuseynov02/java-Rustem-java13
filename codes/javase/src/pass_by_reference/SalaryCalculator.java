package pass_by_reference;

public class SalaryCalculator {

	void calculateSalary(Person p ) {
		p.salary = p.experienceYear * 500;
		 
		System.out.println(p.salary);
	}
}
