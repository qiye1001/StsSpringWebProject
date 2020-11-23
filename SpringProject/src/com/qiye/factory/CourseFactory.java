package com.qiye.factory;

import com.qiye.newInstance.HTMLCourse;
import com.qiye.newInstance.ICourse;
import com.qiye.newInstance.JavaCourse;

public class CourseFactory {
	
	public static ICourse getCourse(String name) {
		if(name.equals("java")) return new JavaCourse();
		return new HTMLCourse();
	}

}
