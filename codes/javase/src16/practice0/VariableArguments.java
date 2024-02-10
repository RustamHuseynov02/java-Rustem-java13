package practice0;

public class VariableArguments {

	public static void main(String[] args) {
		int[] massiv = new int[] {1,3,6,8};
		int[] massiv1 = new int[] {4,3,6,8,3};
		int[] massiv2 = new int[] {1,3,7,8,6,99};
		
		method(massiv);
		method(massiv1);
		method(massiv2);

	}
	
	public static void method(int[] massiv) {
			System.out.println("massivlerimin uzunlugu : " + massiv.length );
		
		
	}

}
