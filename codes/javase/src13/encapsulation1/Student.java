package encapsulation1;

public class Student {

	String name;
	int age;

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void Age(int age) {
		if (age > 0) {
			System.out.println("yasiniz tesdiqlendi");
		} else {
			System.out.println("yasinizi dogru daxil edin");
		}
	}
}
