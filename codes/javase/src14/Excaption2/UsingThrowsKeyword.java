package Excaption2;

import java.io.IOException;

public class UsingThrowsKeyword {
     public static void main(String[] args) {

    	 try {
    			Method(20);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
     }
     
     public static void Method(int a) throws RuntimeException {
    	 int result = 0;
    	 if (a == 20) {
    		 result = a / 0;
			throw new ArithmeticException();
		}
     }
}
