package MetodPractice;

public class MainClass {
     public static void main(String[] args) {
		Circle circle = new Circle();
		circle.radius = 5;
		//
		
		Calculator2 calculate = new Calculator2();
		calculate.calculateCircleLength(circle);
		
		System.out.println(circle.length);
	}
}
