package Override;

public class Class_1 {
	public static void main(String[] args) {

		Animal[] animals = new Animal[6];
		animals[0] = new Cat("Mestan");
		animals[1] = new Dog("Bob");
		animals[2] = new Bird("Qartal");
		animals[3] = new Fish("Nemo");
		animals[4] = new Duck("Balaken ordeki");
		animals[5] = new Horse("Winning Brew");
        
		
		for (Animal animal : animals) {
			animal.speak();
			animal.run();
			animal.swim();
		}
		
		
		
//       Dog dog = new Dog("Bob");
//       dog.speak();
//       Cat cat = new Cat("Mestan");
//       cat.speak();
//       Bird birds = new Bird("Qartal");
//       birds.fly("Uça bilir");
//       //
//       System.out.println("Itin adi : " + dog.name);
//       System.out.println("Pisikin adi : " + cat.name);
//       System.out.println("Uça bilen quş : " + birds.name);

	}
}
