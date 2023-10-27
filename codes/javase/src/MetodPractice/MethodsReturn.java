package MetodPractice;

public class MethodsReturn {

	public static void main(String[] args) {
		
		Calculator calculator = new Calculator();
		int result = calculator.average(50, 50);
		int result1 = calculator.average(1000, 1000);
		
		
		System.out.println(result);
		System.out.println(result1);
		
		
	}
}
