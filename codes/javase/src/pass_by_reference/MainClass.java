package pass_by_reference;

public class MainClass {
  
	
   public static void main(String[] args) {
	   Person person1 = new Person("Rustem","Huseynov","994555554505",5);
	   Person person2 = new Person("Kamil","Memmedov","994777774505",10);
	   SalaryCalculator calculate = new SalaryCalculator();
	   calculate.calculateSalary(person1);
	   calculate.calculateSalary(person2);
	   person1.printInfo();
	   System.out.println("--------");
	   person2.printInfo();
}
}
