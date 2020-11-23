package com.qiye.service.impl;

import com.qiye.dao.IStudentDao;
import com.qiye.service.IStudentService;

public class StudentServiceImpl implements IStudentService{
	IStudentDao student;
	
	@Override
	public void queryStudentById() {
		student.queryStudentById();
	}

}
