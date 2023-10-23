package Evisi2;

public class Employee {
     int id;
     String name;
     String surName;
     String phone;
     String address;
     int salary;
     
     public Employee() {
    	 System.out.println("default");
     }
     public Employee(String name) {
    	 this.name = name;
    	 System.out.println(name);
     }
     public Employee(String name, String surName) {
    	 this.name = name;
    	 this.surName = surName;
    	 System.out.println(name + " " + surName);
     }
     public Employee(String name,String phone, String address) {
    	 this.name = name;
    	 this.phone = phone;
    	 this.address = address;
    	 
    	 System.out.println("Name : " + name +  " Phone : " + phone + " Address : " + address);
    	 
     }
}
