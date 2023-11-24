package Switch1;

import java.util.Scanner;

public class CalculateSwicthExample {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Ilk reqemi secin");
		int sayi1 = scanner.nextInt();
		
		System.out.println("Ikinci reqemi daxil edin");
		int sayi2 = scanner.nextInt();
		
		System.out.println("bu reqemler arasinda +,-,/,* islerini gorun");
		char operator = scanner.next().charAt(0);

		switch (operator) {
		case '+':
			int result = sayi1 + sayi2;
			System.out.println("Yekun : " + result);
			break;
		case '-':
			int result1 = sayi1 - sayi2;
			System.out.println("Yekun : " + result1);
			break;
		case '/':
			int result3 = sayi1 / sayi2;
			System.out.println("Yekun : " + result3);
			break;
		case '*':
			int result4 = sayi1 * sayi2;
			System.out.println("Yekun : " + result4);
			break;

		}
		
		scanner.close();

	}
}
