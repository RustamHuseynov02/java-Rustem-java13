package Switch1;

import java.util.Scanner;

public class AnimalSwicthExample {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Hansi Heyvan Haqqinda Melumat almaq isteyirsiniz?");

		String animals = scanner.next().toString();

		switch (animals) {
		case "Dog":
			System.out.println("Sadiq heyvandir ....");
			break;
		case "Cat":
			System.out.println("Sevimli heyvandir .....");
			break;
		case "Bird":
			System.out.println("Ucmagi bazaran heyvandir ....");
			break;

		default:
			System.out.println("Bu heyvanla bagli melumat yoxdur");
			break;
		}

		scanner.close();
	}
}
