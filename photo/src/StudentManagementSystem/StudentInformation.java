package StudentManagementSystem;

public class StudentInformation {
	int id;
	String name;
	int age;
	String sex;

	public StudentInformation() {
		super();
	}

	public StudentInformation(int id, String name, int age, String sex) {
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
		return "StudentInformation [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}

}
