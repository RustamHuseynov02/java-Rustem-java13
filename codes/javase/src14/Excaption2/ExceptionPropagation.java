package Excaption2;

public class ExceptionPropagation {

	public static void main(String[] args) {

		try {
			A();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
     public static void A() throws Exception{
    	 System.out.println("Metod b buraya daxil olmamisdan evvel");
    	 B();
    	 System.out.println("daxil olduqdan sonra");
     }
     public static void B() throws Exception{
    	 throw new Exception("Metod B ");
     }
}
