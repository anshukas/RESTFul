package com.quantiphi.database;

import java.util.Map;
import java.util.HashMap;

import com.quantiphi.model.Course;

public class DatabaseClass {
	// this is not thread safe not do such way code in production
	
	public static Map<Long, Course> courses = new HashMap<>();

	public static Map<Long, Course> getCourses() {
		return courses;
	}
	
}
