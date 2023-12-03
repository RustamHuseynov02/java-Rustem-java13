package ders_calismasi_1;

import java.util.ArrayList;

public class Main_Class_01 {

	public static void main(String[] args) {
		MyList<Integer> list = new MyList(3,3);
		list.addNew(3);
		list.addNew(9);
		list.addNew(6);
		list.addNew(4);
		list.addNew(5);
		//System.out.println(list.strReturn());
		list.removeMethod(0);
		System.out.println(list.strReturn());
		
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("Salam");
		list1.add("Dunya");
		list1.add("netersuz");
		
		
		
		System.out.println(list1.toString());
		

	}

}
