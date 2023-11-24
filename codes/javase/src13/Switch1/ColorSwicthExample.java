package Switch1;

import java.util.Scanner;

public class ColorSwicthExample {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Hansi Rengi Secirsiniz?");

		String color = scanner.next().toString();

		switch (color) {
		case "Red":
			System.out.println("Narin Rengi");
			break;
		case "Blue":
			System.out.println("Semanin Rengi");
			break;
		case "green":
			System.out.println("Otlarin Rengi");
			break;

		default:
			System.out.println("daxil etdiyiniz reng secenekler arasinda yoxdur");
			break;
		}

		scanner.close();
	}
}
