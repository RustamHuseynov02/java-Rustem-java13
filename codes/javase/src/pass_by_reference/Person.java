package pass_by_reference;

public class Person {
     
	String name;
	String surName;
	String phone;
	int experienceYear;
	int salary;
	
	
	public Person(String name,String surName,String phone,int experienceYear) {
		this.name = name;
		this.surName = surName;
		this.phone = phone;
		this.experienceYear = experienceYear;
	}
	
	
	void printInfo() {
		System.out.println("name : " + name);
		System.out.println("surName : " + surName);
		System.out.println("phone : " + phone);
		System.out.println("experience : " + experienceYear);
		System.out.println("salary: " + salary);
		
		
	}
	
}
