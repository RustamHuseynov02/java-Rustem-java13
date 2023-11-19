package oophomework;

public class Employee extends Person {
    double salary;
    String department;
    String userName;
    String password;
    
    @Override
    public void printInfo(int id, String name, String surname, int age, int phone, String address) {
    	super.printInfo(id, name, surname, age, phone, address);
    	System.out.println("salary : " + salary);
    	System.out.println("department : " + department);
    	System.out.println("userName : " + userName);
    	System.out.println("password : " + password);
    }
}
