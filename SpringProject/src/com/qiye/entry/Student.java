package com.qiye.entry;

import com.qiye.newInstance.HTMLCourse;
import com.qiye.newInstance.ICourse;
import com.qiye.newInstance.JavaCourse;

public class Student {
	private String stuNo;
	private String stuName;
	private String stuAge;
	public String getStuNo() {
		return stuNo;
	}
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuAge() {
		return stuAge;
	}
	public void setStuAge(String stuAge) {
		this.stuAge = stuAge;
	}
	@Override
	public String toString() {
		return "Student [stuNo=" + stuNo + ", stuName=" + stuName + ", stuAge=" + stuAge + "]";
	}
	
	 public void leaveHTML() {
		 ICourse course = new HTMLCourse();
		 course.leave();
	 }
	 
	 public void leaveJava() {
		 ICourse course = new JavaCourse();
		 course.leave();
	 }
}
