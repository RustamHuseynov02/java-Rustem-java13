package Switch1;

import java.util.Scanner;

public class SortSwicthExample {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		 System.out.print("Bir sayı girin: ");
	        int sayi = scanner.nextInt();

	        System.out.println("Geri sayılıyor:");

	        switch (sayi) {
	        case 1:
	        case 2:
	        case 3:
	        case 4:
	        case 5:
	        case 6:
	        case 7:
	        	for (int i = sayi; i >= 1 ; i--) {
					System.out.println(i);
				}
	        }


		scanner.close();
		}
	

}
