package com.mbrdi.hibernate_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mbrdi.hibernate_demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		//create session factory
		SessionFactory factory = new Configuration().
								 configure("hibernate_config.xml").
								 addAnnotatedClass(Student.class).
								 buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//create a student object
			Student student = new Student("avi","kumar","avi@gmail.com");
			
			//Start a transaction
			session.beginTransaction();
			
			//save the student object
			session.save(student);
			
			//commit transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}
