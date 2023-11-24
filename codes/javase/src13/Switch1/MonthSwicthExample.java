package Switch1;

import java.util.Scanner;

public class MonthSwicthExample {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Ayi daxil edin : ");

		String Month = scanner.next().toString();

		switch (Month) {
		case "January":
			System.out.println("Bu ayda " + 30 + " gun var");

			break;
		case "February":

			System.out.println("Bu ayda " + 28 + " gun var");
			break;
		case "March":

			System.out.println("Bu ayda " + 31 + " gun var");
			break;
		case "April":

			System.out.println("Bu ayda " + 30 + " gun var");
			break;
		case "May":

			System.out.println("Bu ayda " + 31 + " gun var");
			break;
		case "June":

			System.out.println("Bu ayda " + 31 + " gun var");
			break;
		case "July":

			System.out.println("Bu ayda " + 30 + " gun var");
			break;
		case "August":

			System.out.println("Bu ayda " + 30 + " gun var");
			break;
		case "September":

			System.out.println("Bu ayda " + 31 + " gun var");
			break;

		case "October":

			System.out.println("Bu ayda " + 30 + " gun var");
			break;
		case "November ":

			System.out.println("Bu ayda " + 30 + " gun var");
			break;
		case "December":

			System.out.println("Bu ayda " + 31 + " gun var");
			break;
		}

	}

}
