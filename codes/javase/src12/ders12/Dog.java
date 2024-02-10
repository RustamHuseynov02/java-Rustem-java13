package ders12;

public class Dog extends Animal {

	private String color;
	private String gender;

	public Dog(String name, int birthday, double weight, String color, String gender) {
		super(name, birthday, weight);
		this.color = color;
		this.gender = gender;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
