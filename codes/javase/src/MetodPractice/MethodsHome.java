package MetodPractice;

public class MethodsHome {
	
	void printNumbers (int begin, int end) {
//		begin = 2;
//		end = 5;
		
		System.out.println(begin);
		System.out.println(end);
		
		
	}
     public static void main(String[] args) {
		MethodsHome methods = new MethodsHome();
		methods.printNumbers(1, 4);
		methods.printNumbers(4, 7);
		methods.printNumbers(3, 6);
	}
}
