package EvIsi;

public class ClassAndObjectHome {
	
      public static void main(String [] args) {
		 Person p1 = new Person();
		 p1.id = 1;
		 p1.name ="Rustam";
		 p1.surName = "Huseynov";
		 p1.age = 20;
		 p1.phone = "+994995000050"; //fake phone )
		 
		 Person p2 = new Person();
		 p2.id = 2;
		 p2.name ="Resul";
		 p2.surName = "Babishov";
		 p2.age = 23;
		 p2.phone = "+994995005500";
		
		 
		 System.out.println(p1.id);
		 System.out.println(p1.name);
		 System.out.println(p1.surName);
		 System.out.println(p1.age);
		 System.out.println(p1.phone);
		 
		 System.out.println("--------");
		 
		 System.out.println(p2.id);
		 System.out.println(p2.name);
		 System.out.println(p2.surName);
		 System.out.println(p2.age);
		 System.out.println(p2.phone);
	}
      
      
}
