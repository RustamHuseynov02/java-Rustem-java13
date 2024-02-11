package lambda;

public class MainClass {
 public static void main(String[] args) {
	
	 
	 doIt(a-> System.out.println("bloklandin" + a));

	
}
 
 public static void doIt(Blockable b) {
     b.block(2);
}

}