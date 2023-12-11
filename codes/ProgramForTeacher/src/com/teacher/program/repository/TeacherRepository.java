package com.teacher.program.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.teacher.program.entity.TeacherEntity;
import com.teacher.program.entity.TeacherGroupEntity;
import com.teacher.program.exception.OurRuntimeException;

public class TeacherRepository {

	public void add(TeacherEntity teacher) throws RuntimeException {
		if (teacher.getName().length() > 50) {
			throw new OurRuntimeException("adiniz max 50 simvol daxil olmalidir");
		} else if (teacher.getSurName().length() > 50) {
			throw new OurRuntimeException("soyadiniz max 50 simvol daxil olmalidir");
		}

		String query = "INSERT INTO teachers" + "(name,surname,phone,address,username,password) values" + "('"
				+ teacher.getName() + "','" + teacher.getSurName() + "','" + teacher.getPhone() + "','"
				+ teacher.getAddress() + "','" + teacher.getUserName() + "','" + teacher.getPassword() + "')";

		try {
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/java13_teacher?useSSL=false",
					"root", "012345");
			Statement state = connect.createStatement();
			state.executeUpdate(query);

			connect.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public boolean checkUserNameIfExists(String username) {

		boolean exists = false;

		String query = "SELECT count(*) FROM teachers where username='" + username + "'";

		try {
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/java13_teacher?useSSL=false",
					"root", "012345");
			Statement state = connect.createStatement();
			ResultSet result = state.executeQuery(query);

			result.next();
			exists = result.getInt(1) == 1 ? true : false;

			connect.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return exists;
	}

	public boolean checkUserIfExists(String username, String password) {

		boolean exists = false;

		String query = "SELECT count(*) FROM teachers where username='" + username + "' and password = '" + password
				+ "';";

		try {
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/java13_teacher?useSSL=false",
					"root", "012345");
			Statement state = connect.createStatement();
			ResultSet result = state.executeQuery(query);

			result.next();
			exists = result.getInt(1) == 1 ? true : false;

			connect.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return exists;
	}

	
	
}
