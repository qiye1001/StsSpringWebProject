package com.qiye.entry;

public class Teacher {
	private String name;
	private String age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Teacher(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Teacher() {
		super();
	}

	@Override
	public String toString() {
		return "Teacher [name=" + name + ", age=" + age + "]";
	}

}
