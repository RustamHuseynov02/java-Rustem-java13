package HomeWork9;

public  class Person {
     String name;
     private long id;
     public int age ;
     protected int weekDays;
     static String surName;
     
     
     // Methods
     void Man (String name) {
    	 if (name == "Rustem" ) {
			System.out.println("Şəxsiyyət Doğrulandı");
		}
    	 else {
    		 System.out.println("Yanlış!");
    	 }
    	 
     }
     private void getIdentity() {
    	 //private oldugu ucun mainnen parametr gondermek olmur
     }
     public void Age(int age) {
    	 if (age <= 20) {
			System.out.println("Yasiniz Catir");
		}
    	 else {
    		 System.out.println("yasiniz catmir");
    	 }
     }
     protected void WeekDay(String[] gunler ) {
    	 for (int i = 0; i < gunler.length; i++) {
    		 if (i < 5) {
    				System.out.println(gunler[i] + ": İş günü");
    			}
    	    	 else {
    	    		 System.out.println(gunler[i] + ": Ev günü");
    	    	 }
		}	

    	 
    	 
	}
    
     public String SurNames(String s) {
	     this.surName = s;
	     return s;
	}
     
     
     public void Final(final int sum) {
    	 System.out.println("final parametr qebul eden : " + sum);
    	 
    	 
     }
     
     // constructors
     
     Person (String name) {
    	this.name = name;
     }
     private Person (long id) {
    	 
     }
     public Person (int age) {
    	 this.age = age;
     }
     protected Person (double birthDay) {
    	 
     }
     
     
     
     
     
}
