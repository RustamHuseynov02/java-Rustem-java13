package encapsulation1;

public class MyClass_1 {
      public static void main(String[] args) {
    	  Student s = new Student("Rustem",20);
    	  s.Age(20);
    	  
    	  //
    	  ImmutablePoint immutable = new ImmutablePoint("Rustem" , "Kenan");
    	  String result = immutable.getX();
    	  
    	  System.out.println(result);
    	  
    	  //
    	  BankAccount bank = new BankAccount();
    	  bank.setBalance(33.3);
	}
     
}
