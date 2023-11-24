package Switch1;

import java.util.Scanner;

public class CharExample {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("simvolu qeyd edin");
        char grade = scanner.next().charAt(0);
        
        switch (grade) {
		case 'A':
			System.out.println("Ela");
			break;
		case 'B':
			System.out.println("Yaxsi");
			break;
		case 'C':
			System.out.println("Orta");
			break;
		case 'D':
			System.out.println("Pis");
			break;
		case 'F':
			System.out.println("Cox pis");
			break;

		
		}
        
        scanner.close();
	}
}
