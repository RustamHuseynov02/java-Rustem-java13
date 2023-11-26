package Excaption;

import java.io.ObjectInputStream.GetField;

public class arithmetic {

	public static void main(String[] args) {

		int a = 7;
		int c = 0;
		//
		String b = "Rustem";
		int d = 0;

		//

		try {
			c = a / 2;
//			d = Integer.parseInt(b);

			Method(101);
			Message(-1);

		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		} catch (OutOfRangeValueException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("try`in icine girsede girmesede calisacaq");
		}

	}

	public static int Message(int a) {

		if (a < 0) {
			throw new IllegalArgumentException("Gonderdiyiniz reqem - reqemdir");
		}

		return a;
	}

	public static int Method(int a) {
		int alt = 0;
		int ust = 100;

		if (a < alt  || a > ust) {
			throw new OutOfRangeValueException("uygun deil");
		}

		return a;

	}
}
