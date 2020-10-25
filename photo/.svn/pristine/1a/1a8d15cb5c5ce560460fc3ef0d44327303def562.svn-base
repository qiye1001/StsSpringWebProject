package Collection;

public class Cat {
	private String name;
	private int id;
	private int age;

	public Cat(String name, int id, int age) {
		super();
		this.name = name;
		this.id = id;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Cat [name=" + name + ", id=" + id + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = result * prime + age;
		result = result * prime + id;
		result = result * prime + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		Cat cat = (Cat)obj;
		if(age != cat.age) {
			return false;
		}
		if(id != cat.id) {
			return false;
		}
		if(name == null) {
			if(cat.name != null) {
				return false;
			}
		} else if (!name.equals(cat.name)) {
			return false;
		}
		return true;
		
	}
}
