package Override;

public class Fish extends Animal {

	public Fish(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void speak() {
		System.out.println("not sound : " + name);
		
	}
	
	@Override
	public void swim() {
		System.out.println("Yaxsi uzur : " + name);
	}

}
