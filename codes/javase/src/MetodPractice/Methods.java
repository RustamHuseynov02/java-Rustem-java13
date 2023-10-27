package MetodPractice;

public class Methods {
	 
	void printName (int count, String name) {
		count = 3;
		name = "Hello";
		
		System.out.println("name : " + name);
		System.out.println("name : " + name);
		System.out.println("name : " + name);
	}
	
     public static void main(String[] args) {
		
    	 Methods method = new Methods();
    	 method.printName(3,"Rustem");
    	 method.printName(3,"Resul");
    	 method.printName(3,"Kamil");
    	 
    	 
	}
}
