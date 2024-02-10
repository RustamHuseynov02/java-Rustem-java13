package ders12;

public class Animal {
private String name;
private int birthday;
private double weight;


public Animal(String name, int birthday, double weight) {
	this.name = name;
	this.birthday = birthday;
	this.weight = weight;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getBirthday() {
	return birthday;
}
public void setBirthday(int birthday) {
	this.birthday = birthday;
}
public double getWeight() {
	return weight;
}
public void setWeight(double weight) {
	this.weight = weight;
}


}
