package Evisi2;

public class ClassAndObjectAndConstructorsHome {
	
	public static void main(String[] args) {
		Employee employee1 = new Employee();
		
		System.out.println("-------");
		
		Employee employee2 = new Employee("Rustem");
		employee2.name = "Resul";
		
		System.out.println("-------");
		
		Employee employee3 = new Employee("Rustem","Huseynov");
		employee3.name = "Kamil";
		employee3.surName = "Memmedov";
		
		System.out.println("-------");
		
		Employee employee4 = new Employee("Rustem","+994995000050","Sumgait city ....");
		employee4.name = "Ahmed";
		employee4.phone = "+994772220022";
		employee4.address = "Turkey,Samsun City";
		
		System.out.println("Mainin icindekiler ");
		
		
		System.out.println("1.Employee : " + employee2.name);
		
		System.out.println("2.Employee Name : " + employee3.name);
		System.out.println("2.Employee SurName : " + employee3.surName );
		
		System.out.println("3.Employee Name : " + employee4.name);
		System.out.println("3.Employee Phone : " + employee4.phone);
		System.out.println("3.Employee Address : " + employee4.address);
		
		
	}

}
