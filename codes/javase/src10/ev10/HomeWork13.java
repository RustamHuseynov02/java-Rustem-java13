package ev10;

import java.util.Random;

public class HomeWork13 {

	public static void main(String[] args) {
		char[] symbol = new char[] { 'S', 'A', 'L', 'A', 'M' };
		Random randomCount = new Random();
		String change = String.copyValueOf(symbol);
		System.out.println("Stringe cevrildi: " + change);

		//

		if (change.length() == 5) {

			boolean t = true;
			for (int i = 0; i < change.length(); i++) {
				change.substring(0, 2);
				char karakter = change.charAt(i);
				if ((karakter < 'A' || karakter > 'Z') && (karakter < 'a' || karakter > 'z')) {
					t = false;
					break;
				}
			}

			if (t) {
				System.out.println("ingilis elifbasidi");
			} else {
				System.out.println("ingilis elifbasi deyil");
			}
		} else {
			System.out.println("3 simvoldan olusmur");
		}

		//

		if (change.isEmpty()) {
			System.out.println("ici bosdur");
		} else {
			System.out.println("ici bos degil");
		}

		//
		boolean result = method("salam dunya", "dunya");
		System.out.println(result);

		//
		int count = randomCount.nextInt(21) + 10;
		System.out.println("10 ile 30 arasinda" + count);

		//
		
		double d = 50.5000;
		d = d * 100;
		System.out.println(d);
		d = d / 100;
		System.out.println(d);
		double result2 = Math.round(d);
		System.out.println(result2);
	}

	public static boolean method(String a, String b) {

		// boolean result = a.endsWith(b);

		boolean end = a.endsWith("dunya") && b.endsWith("dunya");

		return end;

	}
}
