package Override;

public class Duck extends Animal {

	public Duck(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void speak() {
		System.out.println("bu sesi cixaran heyvan [beee] : " + name);
		
	}
	
	@Override
	public void swim() {
		System.out.println("suyun ustunde uzur :" + name);
	}

}
