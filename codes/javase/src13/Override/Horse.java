package Override;

public class Horse extends Animal {

	public Horse(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void speak() {
		System.out.println("bu sesi cixaran heyvan [kisniyir] : " + name);

	}
	@Override
	public void swim() {
		System.out.println("uzmeyi bacarmir : " + name);
	}
	@Override
	public void run() {
		
		System.out.println("Dunyanin en suretli ati : " + name);
	}

}
