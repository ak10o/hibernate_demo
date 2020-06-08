package com.mbrdi.hibernate_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mbrdi.hibernate_demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		//create session factory
		SessionFactory factory = new Configuration().
								 configure("hibernate_config.xml").
								 addAnnotatedClass(Student.class).
								 buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 6;
			//Start a transaction
			session.beginTransaction();
			
			//retrieve the student object
			Student retrievedStudent = session.get(Student.class, studentId);
			
			//update a student object
			retrievedStudent.setFirstName("scooby");
			
			//commit transaction so that changes is  reflected in db
			session.getTransaction().commit();
			
			// bulk update
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("update Student s set s.email='foo@gmail.com' where "
					+ " s.lastName='kumar'").executeUpdate();
			
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}	
}
