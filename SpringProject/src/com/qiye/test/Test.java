package com.qiye.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qiye.entry.AllColleactionType;
import com.qiye.entry.Course;
import com.qiye.entry.Student;
import com.qiye.entry.Teacher;
import com.qiye.factory.CourseFactory;
import com.qiye.newInstance.ICourse;
import com.qiye.service.IStudentService;

public class Test {
	
	public static void testAop() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IStudentService service = (IStudentService)context.getBean("studentServiceImpl");
		Student stu = new Student();
		service.addStudent(stu);
	}
	
	public static void springIOC() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		Student student = (Student)context.getBean("studentCourse");
//		System.out.println(student);
//		Course course = (Course)context.getBean("course");
//		System.out.println(course);
//		Course course = (Course)context.getBean("course-p");
//		System.out.println(course);
//		AllColleactionType course = (AllColleactionType)context.getBean("allColleactionType");
//		System.out.println(course);
	}
	
	public static void leaveCourseWidthFactory() {
		ICourse course = CourseFactory.getCourse("java");
		course.leave();
	}
	
	public static void leaveCourse() {
		Student student = new Student();
		student.leaveHTML();
		student.leaveJava();
	}
	
	public static void main(String[] args) {
//		leaveCourse();
//		leaveCourseWidthFactory();
//		springIOC();
		testAop();
	}
}
