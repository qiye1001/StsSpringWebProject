package com.qiye.dao.impl;

import org.springframework.stereotype.Component;

import com.qiye.dao.IStudentDao;
import com.qiye.entry.Student;


@Component("studentDao")	// 等同于<bean id="studentDao" class="com.qiye.dao.StudentDaoImpl"></bean>
public class StudentDaoImpl implements IStudentDao{
	
	@Override
	public void addStudent(Student stu) {
		System.out.println("增加学生");
	}

	@Override
	public void deleteStudentById(int id) {
		System.out.println("删除学生");
	}
}
