package ev10;

import java.util.Arrays;

public class HomeWork11 {

	public static void main(String[] args) {
		String name = "Cavid";
		name = "      Adil ";
		name = "Bextiyar";
		name = "Eli Hasanov";
		String[] split3 = name.split("");
		System.out.println(name);
		String message = "Java dili güclü və effektli bir proqramlaşdırma dilidir";
		System.out.println(message);
		System.out.println("message simvol sayisi : " + message.length());
		System.out.println("message degiseninin 2 ci simvolu : " + message.charAt(2));
		System.out.println("ilk i simvolunun necenci indexsde oldugunu tapiriq : " + message.indexOf("i"));
		System.out.println("sonuncu i simvolunun necenci indexsde oldugunu tapiriq : " + message.lastIndexOf("i"));
		System.out.println("Lower Case : " + message.toLowerCase());
		System.out.println("Upper Case : " + message.toUpperCase());
		System.out.println("Bosluqlari aradan qaldir : " + name.trim());
		System.out.println("ilk 4 setir : " + name.substring(0, 4));
		System.out.println("split ile boldum alinan massiv : " + Arrays.toString(split3));

		if (message.contains("a")) {
			System.out.println("message setirinde bu simvol var");
		} else {
			System.out.println("bu simvol yoxdur");
		}

		//

		if (message.endsWith("ir")) {
			System.out.println("Beli bununla bitir");
		} else {
			System.out.println("yanlis");
		}

		//

		if (message.startsWith("Java")) {
			System.out.println("Beli bununla baslayir");
		} else {
			System.out.println("yanlis");
		}

	}

}
