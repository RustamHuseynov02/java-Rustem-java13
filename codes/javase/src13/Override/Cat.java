package Override;

public class Cat extends Animal {

	public Cat(String name) {
		super(name);
		
	}
	@Override
	public void speak() {
		System.out.println("bu sesi cixaran heyvan [meow] : " + name);
	}

}
