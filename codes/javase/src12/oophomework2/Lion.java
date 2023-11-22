package oophomework2;

public class Lion extends Animal {

	double weight;
	String color;
	String gender;
	String roar;

	public Lion(String name,int age,double weight, String color, String gender,String roar) {
		super(name, age);
		this.weight = weight;
		this.color = color;
		this.gender = gender;
		this.roar = roar;

	}

	

	@Override
	public void makeNoise(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("adi : " + name + " | " + "yasi : " + age);

	}

}
