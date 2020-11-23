package com.qiye.dao;

import com.qiye.entry.Student;

public interface IStudentDao {
	void addStudent(Student stu);
	void deleteStudentById(int id);
}
