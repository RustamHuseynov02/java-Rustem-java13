package Override;

public class Dog extends Animal {

	public Dog(String name) {
		super(name);
	}
	@Override
	public void speak() {
		System.out.println("bu sesi cixaran heyvan [Bark] : " + name);
		
	}
}
