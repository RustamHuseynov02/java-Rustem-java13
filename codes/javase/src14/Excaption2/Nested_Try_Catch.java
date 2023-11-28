package Excaption2;

public class Nested_Try_Catch {

	public static void main(String[] args) {

		int[] array = { 0, 22, 44, 32, 42 };

		try {
			try {
				int result = array[1] / array[0]; // burada eger 0 - 1 etsek ArrayIndexOutOfBoundsException bas verecek yeni 2 sertide qarsilayir
				System.out.println(result);
			} catch (ArithmeticException e) {
				System.out.println(e.getMessage());
			}
		} catch (ArrayIndexOutOfBoundsException e) {
         System.out.println(e.getMessage());
			
		}

		System.out.println("ic-icedi try-catchler");

	}

}
