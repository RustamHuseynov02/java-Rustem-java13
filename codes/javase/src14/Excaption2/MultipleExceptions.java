package Excaption2;

public class MultipleExceptions {

	public static void main(String[] args) {
		
		int[] array = {1,5,9,7};
		int result = 0;
		
		System.out.println(result);
		
		try {
//			for (int i = 0; i < array.length; i++) {
//				result = array[i] / 0;
//			}
//			String is = null;
//			int a = is.length();
			
			if (array[1] == array[0-1]) {
				System.out.println("Beraberdi");
			}
			
		} catch (ArithmeticException | NullPointerException | ArrayIndexOutOfBoundsException ex ) {

			System.out.println(ex.getMessage());
			
		}

	}

}
