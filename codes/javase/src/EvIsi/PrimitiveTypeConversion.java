package EvIsi;

public class PrimitiveTypeConversion {

	public static void main(String[] args) {
		short s = 69;
		byte b = (byte)s;
		System.out.println(b);
		
		//
		
		short s1 = 589;
		byte b1 = (byte)s1;
		System.out.println(b1);
		
		//
		
		long l = 589;
		int i = (int)l;
		System.out.println(i);
		
		//
		
		long l1 = 525255483;
		int i1 = (int)l1;
		System.out.println(i1);
		
		//
		
		double d = 5632.6;
		float f = (float)d;
		System.out.println(f);
		
		//
		
		char c = 'D';
		int test = (int)c;
		System.out.println(test);
		
		//
		
		int test1 = 123;
		char c1 = (char)test1;
		System.out.println(c1);
	}

}
