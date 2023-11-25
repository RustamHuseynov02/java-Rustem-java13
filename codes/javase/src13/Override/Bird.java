package Override;

public class Bird extends Animal {

	public Bird(String name) {
		super(name);

	}

	public void fly(String type) {
		
        if (type.equals("Uça bilir")) {
			System.out.println("Qusun adi : " + name );
		}
        else {
        	System.out.println("calismadi");
        }
	}
	
	@Override
	public void speak() {
		System.out.println("bu sesi cixaran heyvan [çiiuuu] : " + name);
	}

}
