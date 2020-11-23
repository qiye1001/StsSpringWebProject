package com.qiye.entry;

public class Course {
	private String courseHour;
	private String courseName;
	private Teacher teacher;

	public String getCourseHour() {
		return courseHour;
	}

	public void setCourseHour(String courseHour) {
		this.courseHour = courseHour;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Course(String courseHour, String courseName, Teacher teacher) {
		super();
		this.courseHour = courseHour;
		this.courseName = courseName;
		this.teacher = teacher;
	}

	public Course() {
		super();
	}

	@Override
	public String toString() {
		return "Course [courseHour=" + courseHour + ", courseName=" + courseName + ", teacher=" + teacher + "]";
	}

}
