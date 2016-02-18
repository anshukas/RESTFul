package com.quantiphi.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.quantiphi.database.DatabaseClass;
import com.quantiphi.model.Course;

public class CourseService {

	private Map<Long, Course> courses = DatabaseClass.getCourses();

	public CourseService() {
		super();
		//long pnum, String title, String image, String url,String price, String type, String category, String rating,String description
		courses.put(1L, new Course(
				1L,"FE Development",
				"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTYuDOM6kIGxpjKEjpMYsjm2c6ZLRwCtEemxXD9rPrOQf0mILdj",
				"https://www.udacity.com/course/mobile-web-development--cs256",
				"Rs 60,000/month",
				"beginner",
				"FE Development",
				"3",
				"Good at Angular"));
		courses.put(2L, new Course(
				2L,"Java Development",
				"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTYuDOM6kIGxpjKEjpMYsjm2c6ZLRwCtEemxXD9rPrOQf0mILdj",
				"https://www.udacity.com/course/mobile-web-development--cs256",
				"Rs 90000/month",
				"beginner",
				"Web Development",
				"5",
				"Love jersery"));
		courses.put(3L, new Course(
				3L,"Mobile Web Development",
				"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTYuDOM6kIGxpjKEjpMYsjm2c6ZLRwCtEemxXD9rPrOQf0mILdj",
				"https://www.udacity.com/course/mobile-web-development--cs256",
				"Rs 0",
				"beginner",
				"Web Development",
				"4",
				"My name"));
	}
	
	public List<Course> getAllCourses(){
		//Passing the Collection to the ArrayList constructor initialized the List with those elements!
		return new ArrayList<Course>(courses.values());
	}
	
	public String getCount(){
		return Integer.toString(courses.size());
	}

	public List<Course> searchByTitle(String title) {
		// TODO Auto-generated method stub
		List<Course> searchMatchCourses = new ArrayList<>();
		Collection<Course> course = courses.values();
		for (Course someCourse : course) {
			if(someCourse.getTitle().contains(title)){
				//Love you coffee
				searchMatchCourses.add(someCourse);
			}
		}
		return searchMatchCourses;
	}
}
