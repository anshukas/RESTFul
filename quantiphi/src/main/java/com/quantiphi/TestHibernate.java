package com.quantiphi;

import java.util.HashSet;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.quantiphi.model.Course;
import com.quantiphi.model.Student;

public class TestHibernate {
	public static void main(String[] args) {
		@SuppressWarnings("deprecation")
		SessionFactory cfg = new Configuration().configure("hibernate-cfg.xml").buildSessionFactory();
		Session sesson = cfg.getCurrentSession();

		Transaction tx = (Transaction) sesson.beginTransaction();

		Course course = new Course();
		//course.setPnum(4);
		course.setTitle("php");
		course.setCategory("Zend");
		course.setRating("6.0");

		Student anshu = new Student();
		//anshu.setId(8);
		anshu.setName("Sudhanshu");
		//anshu.setCourseId(4);
		/*
		Student chandu = new Student();
		chandu.setId(9);
		chandu.setName("Chandu Yadav");
		chandu.setCourseId(4);
		*/
		HashSet<Student> st = new HashSet<Student>();
		st.add(anshu);
		//st.add(chandu);
		
		course.setStudents(st);
		
		sesson.saveOrUpdate(course);

	/*	//List the course where id =4
		Course course2 =(Course) sesson.get(Course.class, 4);
		System.out.println("course 4: "+course2.toString());

		Criteria crt = sesson.createCriteria(Course.class);
		crt.add(Restrictions.eq("title", "Spring"));
		System.out.println("course list: "+crt.list());*/
		
		//Criteria on child
		Criteria crt2 = sesson.createCriteria(Course.class);
		crt2.createAlias("students","students");
		crt2.add(Restrictions.eq("students.name", "Sudhanshu"));
		System.out.println("Find student with name match: "+crt2.list());

		try {
			tx.commit();
		} catch (SecurityException e) {
			e.printStackTrace();
			try {
				tx.rollback();
			} catch (IllegalStateException e1) {
				e1.printStackTrace();
			}
		}
	}
}