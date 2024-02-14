package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class lambdapractika {

	public static void main(String[] args) {
		
		Integer[] intMassiv = {1,4,66,88,45,54,32,111,2222,33333}; //biz bu elementleri tek tek bolub emeliyyat etmek isteyirikse
		//streamden istifade etmeliyik.bunun ucun massivimizi collections-a cevirmeliyik
		
		
		List<Integer> list = Arrays.asList(intMassiv);   //bu kod bizim massivimizi collections-a cevirir
		System.out.println(list);
		

		
		List<Integer> result = list.stream().filter(e-> e%2==0)   // burada list-i local variable menimsetirem ve icinde alqoritmik emeliyyatlar edirem
		.map(e->e*5)
		.collect(Collectors.toList());
		
		System.out.println(result);
		
		
		//
		
		String[] stringMassiv = {"Ulvi","Maqsud","Firdovsi","Tofiq","Tahir"};
		
		
		List<String> list2 = Arrays.asList(stringMassiv);
		System.out.println(list2);
		
		
		List<String> result2 = list2.stream().filter(e->e.contains("a")).map(e->e.concat("aaaaa"))
		.collect(Collectors.toList());
		
		System.out.println(result2);
		
				

		
	}

}
