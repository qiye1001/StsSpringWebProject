package Reflection;

public class Dog {
	private String name;
	private int age;
	private String color;

	protected void get() {}
	
	private void set(String name) {
		System.out.println(name);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Dog() {
		super();
	}

	public Dog(String name, int age, String color) {
		super();
		this.name = name;
		this.age = age;
		this.color = color;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + ", color=" + color + "]";
	}

}
