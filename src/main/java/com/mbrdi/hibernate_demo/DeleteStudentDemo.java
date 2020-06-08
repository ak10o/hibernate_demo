package com.mbrdi.hibernate_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mbrdi.hibernate_demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate_config.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			int studentId = 8;
			// Start a transaction
			session.beginTransaction();

			// retrieve the student object
			Student deleteStudent = session.get(Student.class, studentId);

			// delete the student object
			session.delete(deleteStudent);

			// commit transaction so that changes is reflected in db
			session.getTransaction().commit();

			// bulk update 
			session = factory.getCurrentSession();
			session.beginTransaction();

			session.createQuery("delete from Student s where s.firstName='daffy'").executeUpdate();

			session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}
}
