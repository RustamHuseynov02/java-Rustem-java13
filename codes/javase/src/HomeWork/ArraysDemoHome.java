package HomeWork;

import java.util.Arrays;

public class ArraysDemoHome {

	public static void main(String[] args) {
		int[] numbers = new int[] { 10, 15, 20, 22, 23, 27, 39, 29 };
		int calculate = 0;
		int result = 0;
		for (int i = 0; i < numbers.length; i++) {
			calculate += numbers[i]; // degerleri toplanildi
			System.out.println("massivin icindeki elementlerin toplami : " + calculate);

			if (numbers.length == 4) { // ededi orta tapildi
				result = calculate / numbers.length;
			}

		}
		System.out.println("massivin icindeki elemenlerin ededi ortasi : " + result);

		for (int number : numbers) { // foreach istifade edildi
			System.out.println("massivin icindeki : " + number);
		}

		int min = numbers[0];
		for (int i = 1; i < numbers.length; i++) { // en kiciki tapiriq
			if (numbers[i] < min) {
				min = numbers[i];
			}
		}
		System.out.println("massivimin icindeki min : " + min);

		int max = numbers[0];
		for (int i = 1; i < numbers.length; i++) { // en boyuku tapiriq
			if (numbers[i] > max) {
				max = numbers[i];
			}
		}
		System.out.println("massivimin icindeki max : " + max);

		for (int i = 0; i < numbers.length; i++) { // tek olanlari tap
			if (numbers[i] % 2 == 1) {
				System.out.println("massivimin icindeki tek ededler : " + numbers[i]);
			}
		}

		for (int i = 0; i < numbers.length; i++) { // cut olanlari tap
			if (numbers[i] % 2 == 0) {
				System.out.println("massivimin icindeki cut ededler : " + numbers[i]);
			}
		}

		for (int i = 0; i < numbers.length; i++) {
			boolean isPrime = true;
			for (int j = 2; j < numbers[i] / 2; j++) {
				if (numbers[i] % j == 0) { // sual: bu kodda ifin icerisi false olanda is prime verdiyimiz deyerde false
											// == false true ya cevrildigi ucun ....
					isPrime = false;
					break;
				}
			}

			if (isPrime) {
				System.out.println("Sade ededler : " + numbers[i]);
			} else {
				System.out.println("Sade eded olmayanlar : " + numbers[i]);
			}
		}

		for (int i = 0; i < numbers.length - 1; i++) {
		    for (int j = 0; j < numbers.length - i - 1; j++) {
		        if (numbers[j] < numbers[j + 1]) {
		            int temp = numbers[j];
		            numbers[j] = numbers[j + 1];
		            numbers[j + 1] = temp;
		        }
		    }
		}
			
		for (int i = 0; i < numbers.length; i++) {
		    System.out.println(numbers[i]);
		}
		
		
//		boolean a = false;
//		boolean b = false;
//		
//		boolean result2 = a == b;
//		System.out.println(result2);
	}
}
