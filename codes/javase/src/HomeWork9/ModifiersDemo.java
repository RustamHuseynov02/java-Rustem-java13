package HomeWork9;

public class ModifiersDemo {
      public static void main(String[] args) {
		Person persons = new Person("Rustem");
		persons.Man(persons.name);
		int min = 20;
		persons.Age(min);
		
		 String[] gunler = {"Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi", "Pazar"};
		persons.WeekDay(gunler);     // weekDay metodu hele bitmeyib bunu nece yazmaq isdeyirem ekrandaki textde bax 
		
		String sur = persons.SurNames("Huseynov");
		
		
		
		final int b = 22;
		persons.Final(b);
		
		
		
		
		
		
		
		
		System.out.println("Default access name : " + persons.name);
		System.out.println("static olan surName main metoduna geri gonderdim : " + sur);
		
	
		
		 
		
		
		
	}
}
