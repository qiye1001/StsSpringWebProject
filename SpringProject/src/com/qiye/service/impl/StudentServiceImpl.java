package com.qiye.service.impl;

import java.sql.SQLException;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.qiye.dao.IStudentDao;
import com.qiye.entry.Student;
import com.qiye.service.IStudentService;

public class StudentServiceImpl implements IStudentService {
	IStudentDao studentDao;

	public void setStudentDao(IStudentDao studentDao) {
		this.studentDao = studentDao;
	}


	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { SQLException.class })
	@Override
	public void addStudent(Student stu) {
		System.out.println("Ìí¼ÓÑ§Éú");
	}

}
