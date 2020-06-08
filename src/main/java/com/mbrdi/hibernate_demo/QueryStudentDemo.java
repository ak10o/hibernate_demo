package com.mbrdi.hibernate_demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mbrdi.hibernate_demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		//create session factory
		SessionFactory factory = new Configuration().
								 configure("hibernate_config.xml").
								 addAnnotatedClass(Student.class).
								 buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//Start a transaction
			session.beginTransaction();
			
			//query the students
			List<Student> students = session.createQuery("from Student s where s.lastName = 'doe' or s.firstName='avi'").getResultList();
			
			//display the student
			for( Student student: students) {
				System.out.println(student);
			}
			
			students = session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
			//commit transaction
			
			for( Student student: students) {
				System.out.println("email " + student);
			}
			
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}
