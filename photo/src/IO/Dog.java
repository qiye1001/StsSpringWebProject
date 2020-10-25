package IO;

import java.io.Serializable;

public class Dog implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 865756585570368951L;
	private String name;
	private int age;
	private String sex;
	private transient int id; // 在序列化中被忽略

	public Dog() {
	}

	public Dog(String name, int age, String sex, int id) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.id = id;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + ", sex=" + sex + ", id=" + id + "]";
	}
}
