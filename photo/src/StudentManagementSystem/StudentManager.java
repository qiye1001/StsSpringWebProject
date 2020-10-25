package StudentManagementSystem;

import java.util.Arrays;

public class StudentManager {
	private StudentInformation[] studentInformation;
	private int count = 0; // 记录当前数组的元素下标个数

	public StudentManager(int Size) {
		if (Size > 0) {
			studentInformation = new StudentInformation[Size];
		} else {
			studentInformation = new StudentInformation[5];
		}
	}

	public void add(StudentInformation student) {
		if (count > studentInformation.length) {
			int newLength =  studentInformation.length * 3 >> 2 + 1;
			studentInformation = Arrays.copyOf(studentInformation, newLength);
		} else {
			studentInformation[count] = student;
			++count;
		}
	}

	public void delete(int id) {
		for(int i = 0; i < count; ++i) {
			if(studentInformation[i].getId() == id) {
				for(int n = i; n < count - 1; ++n) {
					studentInformation[i] = studentInformation[n+1];
				}
				studentInformation[count-1] = null;
				--count;
				break;
			}
		}
	}

	public void update(StudentInformation student) {
		StudentInformation temp = find(student.getId());
		if(temp != null) {
			temp.setName(student.getName());
			temp.setAge(student.getAge());
			temp.setSex(student.getSex());
		}
		
	}

	public StudentInformation find(int id) {
		for(int i = 0; i < studentInformation.length; ++i) {
			if(studentInformation[i].getId() == id) {
				return studentInformation[i];
			}
		}
		return null;
	}

	public void printAll() {
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return "StudentManager " + Arrays.toString(studentInformation);
	}
	
}
