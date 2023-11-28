package Exception3;

public class My_Class_01 {

	public static void main(String[] args) throws InvalidUserInputException {
         String[] str = {"Rustem","Maqsud","Aslan"};
         boolean result = true;
         if (result) {
        	 str[1].equals(str[0 - 1]);
		}
         System.out.println(result);

	}

}
