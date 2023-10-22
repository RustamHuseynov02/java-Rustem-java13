package EvIsi;

public class ClassAndObjectAndConstructors {

	public static void main(String [] args) {
		Computer c1 = new Computer(1,"Asus","ASUS ROG Strix G18 G814JU-N5047","Black");
		Computer c2 = new Computer("ASUS ROG Strix G18 G814JU-N5047");
		Computer c3 = new Computer("ASUS ROG Strix G18 G814JU-N5047","Black");
		
		
		
		
		System.out.println("id : " + c1.id);
		System.out.println("Brand : " + c1.Brand);
		System.out.println("Model : " + c1.Model);
		System.out.println("Color : " + c1.Color);
		System.out.println("Model : " + c2.Model);
		System.out.println("Model : " + c3.Model + " " + " Color : " + c3.Color);
		
	}
	
	
}
