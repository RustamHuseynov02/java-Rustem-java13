package EvIsi;

public class DersPraktikasi2 {

	public static void main(String[] args) {
	    
		
		//1ci tapsiriq
		
		for (int i = 1; i < 100; i++) {
			if(i==1) {
				continue;
			}
			else if(i == 5) {
				break;
			}
			else {
				System.out.println(i);
			}
		}
		
		System.out.println("--------");
		
		//2ci tapsiriq
		
		for (int a = 1; a <= 10; a++) {
		    for (int b = 1; b <= 10; b++) {
		        System.out.println(a + " + " + b + " = " + (a + b));
		    }
		    System.out.println("___________");
		}

	
	     
		//3cu tapsiriq
		
		for (int b = 1; b < 10; b++) {
			for (int a = 1; a < 10; a++) {
				System.out.println(b + "*" + a + "=" + b*a);
			}
			System.out.println("___________");
		}

		System.out.println("--------");
		
		//4cu tapsiriq
		
		
		for (int c = 1; c < 101; c++) {
			System.out.println(c);
		}
		
		System.out.println("--------");
		
		//5ci tapsiriq
		
		for (int d = 1; d < 100; d++) {
			
			if (d%7 == 0) {
				System.out.println(d);
			}
		}
		
		System.out.println("--------");
		
		//6ci tapsiriq
		
		for (int e = 0; e < 50; e++) {
			if (e%2 == 0) {
				System.out.println(e);
			}	
		}
		
		System.out.println("--------");
		
		//7ci tapsiriq
		
		for (int f = 1; f < 200; f++) {
			
			if (f % 3 == 0 && f % 7 ==0) {
				System.out.println(f);
			}
		}
		System.out.println("--------");
		

	}

}
