package d10;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MyClass {
	public static void main(String[] args) {

		String s = "Java is good good is good";
		String m = "Language ";
		String n = "  Language ";
		String a = "Language English";
		String isblank = " ";
		char[] chars = { 'd', 'a', 'r', 'b', 'e' };
		m.getChars(0, 3, chars, 2);
		String result = m.concat(s);
		String[] g = s.split("is");
		String[] split2 = a.split("age");
		boolean end = s.endsWith("od");
		char c = s.charAt(11); // charAt - verilen indexsin simvolunu tapir
		c = m.charAt(5);

		System.out.println(m.indexOf("age")); // anladigim qederi ile burada verileren setirin ilk indexsini tapir
		System.out.println(n.indexOf("gu", 0)); // burada ise 0 ci indexsden baslayaraq axtarir eger men bura 5ci index
												// versem xeta verecek

		System.out.println(s.lastIndexOf("is")); // lastIndexOf-bu ise bir dizinin icinde eger 2 dene is varsa en
													// sonuncunun indexsi verir

		System.out.println("isBlank : " + isblank.isBlank()); // Sətirin boş olmasını yoxlamaq. Boşluqları nəzərə almır.

		System.out.println("isEmpty : " + isblank.isEmpty()); // Sətirin boş olmasını yoxlamaq. Boşluqları nəzərə alır.

		System.out.println(m == n); // equals beraberliyi yoxlayerken "equals : " + bunu qebul etmir m == n
									// true-dusa false eliyir
		System.out.println("endsWith : " + m.endsWith("e "));
		System.out.println("endsWith : " + end);
		System.out.println("charAt : " + c);
		System.out.println("concat : " + result);
		System.out.println("split toString : " + Arrays.toString(g));
		System.out.println("replace : " + n.replace("L", "a")); // burada n setirinde secdiyin herfi istediyin herf ile
																// degisir
		System.out.println("replaceAll :" + n.replaceAll(n, s)); // burada String s setirim n setirinin ile yer deyisme
																	// eledi sadece bu kod blokunda kecerlidi

		System.out.println("replaceFirst : " + s.replaceFirst("good", "better")); // burada s dizinin icinde ki ilk
																					// setiri yer degisme edir

		System.out.println("split : " + Arrays.toString(split2)); // split verdiyin setiri bolur ve massivde 2 element
																	// yazdirir
		System.out.println("StartsWith : " + a.startsWith("Lan")); // endsWith tersinesidi
		System.out.println("Substring : " + s.substring(5, 10)); // burada verdiyim 5 indexsinden baslayaraq verdiyim 10
																	// indexsine qeder
		// gedir ve bitir

		System.out.println("Lower Case : " + a.toLowerCase()); // setirin simvollarini kicildir
		System.out.println("Upper Case : " + s.toUpperCase()); // setirin simvollarini boyudur

		System.out.println(s.contains("is")); // verilen setiri s setirin daxilinde yoxlayir varsa true donecek
		System.out.println(n.trim()); // Sətirin baş və sonunda olan boşluqları yox etmək
		System.out.println("getChars  : " + chars); // bunun izahi uzundu

		// getChars - m sətirinin daxilində olan simvollardan 0-ci dən
		// başlayaraq 3-cü simvola kimi kopiya edilir və chars massivinin 2-ci
		// simvolundan başlayaraq yerləşdirilir və kodun nəticəsi daLan olur.

	}
}
