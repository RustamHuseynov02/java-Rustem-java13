package javase;

public class Main {

	public static void main(String[] args) {
		
		Book kitab = new Book();
		
		kitab.name = "Tarix";
		kitab.author = "Azerbaycan Tarixi";
		kitab.id = 1;
		
		Book kitabHaqqinda = new Book();
		
		kitabHaqqinda.pageCount = 100;
		kitabHaqqinda.description = "Gozel kitab";
		

		System.out.println(kitab.name);
		System.out.println(kitab.author);
		System.out.println(kitab.id);
		System.out.println(kitabHaqqinda.pageCount);
		System.out.println(kitabHaqqinda.description);
	}

}
