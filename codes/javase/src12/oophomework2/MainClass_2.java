package oophomework2;

public class MainClass_2 {
	public static void main(String[] args) {
		Animal[] animals = new Animal[3];
		animals[0] = new Cat("Mestan", 2, 3.4, "yellow", "male", "low");
		animals[1] = new Dog("Jack", 3, 5.4, "black", "male", "normal");
		animals[2] = new Lion("Aslan", 8, 77.9, "yellow", "male", "very strong");

		animals[0].makeNoise("Mesi", 1);
		animals[1].makeNoise("Bob", 3);
		animals[2].makeNoise("King", 7);

//		Lion lions = new Lion();
//		lions.makeNoise("King", 7);

	}
}
