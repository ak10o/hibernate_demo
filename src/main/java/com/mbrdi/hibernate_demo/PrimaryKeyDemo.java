package com.mbrdi.hibernate_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mbrdi.hibernate_demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().
				configure("hibernate_config.xml").
				addAnnotatedClass(Student.class)
				.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();

		try {
			//create three students object
			Student student = new Student("luv", "code", "luv2code@gmail.com");
			Student student1 = new Student("john", "doe", "john@gmail.com");
			Student student2 = new Student("telusko", "alien", "telusko@gmail.com");

			//Start a transaction
			session.beginTransaction();

			//save the student object
			session.save(student);
			session.save(student1);
			session.save(student2);

			//commit transaction
			session.getTransaction().commit();
		} finally {
			factory.close();
		} // TODO Auto-generated method stub

	}

}
