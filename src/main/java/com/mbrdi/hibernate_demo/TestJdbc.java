package com.mbrdi.hibernate_demo;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user = "hbstudent";
		String pwd = "hbstudentzzzz";
		try {
			System.out.println("connecting to " + jdbcUrl);
			Connection myconn = DriverManager.getConnection(jdbcUrl,user,pwd);
			System.out.println("connection is successfull " + myconn);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("exception handling" + e.getMessage());
		}
	}
}
