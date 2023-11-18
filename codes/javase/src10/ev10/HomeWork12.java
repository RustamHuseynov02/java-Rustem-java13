package ev10;

import java.util.Arrays;
import java.util.Random;

public class HomeWork12 {

	public static void main(String[] args) {

		char[] chars = new char[] { 'A', 'B', 'C', 'D', 'E', 's', 'm' };
		Random randomCount = new Random();
		String s = String.copyValueOf(chars);
		System.out.println(s); // 1

		// 2
		// Dize uzunluğunu kontrol et
		if (s.length() == 7) {

			// İngilizce alfabedeki harfleri içerip içermediği kontrol ediliyor
			boolean sadeceIngilizce = true;
			for (int i = 0; i < s.length(); i++) {
				String ilkbes = s.substring(0, 4);
				char karakter = s.charAt(i);
				if ((karakter < 'A' || karakter > 'Z') && (karakter < 'a' || karakter > 'z')) {
					sadeceIngilizce = false;
					break;
				}
			}

			// İngilizce alfabedeki harfleri içeriyorsa ve uzunluğu 5 ise
			if (sadeceIngilizce) {
				System.out.println("Dize 5 karakterden oluşuyor ve sadece İngilizce harfleri içeriyor.");
			} else {
				System.out.println("Dize 5 karakterden oluşuyor ancak sadece İngilizce harfleri içermiyor.");
			}
		} else {
			System.out.println("Dize 5 karakterden oluşmuyor.");
		}
		// 3
		if (s.isEmpty()) {
			System.out.println("ici bosdur");
		} else {
			System.out.println("ici bos degil");
		}

		// 4
		String word1 = "Salam necesiz";
		String word2 = "necesiz";
		String word3 = "Bonjour";
		String result2 = metod(word1, word2, word3);
		System.out.println(result2);
		// 5
		int result = randomCount.nextInt(30)+20;
		System.out.println("30 ile 50 arasinda random reqemler : " +result);

		//6
		
		double total = count(20);
		System.out.println("Verilen ededin kok altini hesapladim : " + total);
		
		//7
		double sum = totalCount(30, 50);
		System.out.println("Verilen ededin quvvet ustunu hesapladim : " + sum);
		
		//8
		double sum2 = 0.0;
		Double[] d = new Double[] {2.56,4.32,3.77,5.54,6.45,9.10,9.97,8.67};
		for (int i = 0; i < d.length; i++) {
			sum2 = round(d[i]);
			System.out.println(sum2);
		}
		
		
	}

	public static String metod(String word1, String word2, String word3) {
		String a = word1.replace(word2, word3);

		return a;
	}
	
	public static double count (double d) {
		double result = Math.sqrt(d);
		return result;
	}
	public static double totalCount (double a, double b) {
		double result = Math.pow(a, b);
		return result;
	}
	public static double round(double c) {
		double result = Math.round(c);
		return result;
	}
}
