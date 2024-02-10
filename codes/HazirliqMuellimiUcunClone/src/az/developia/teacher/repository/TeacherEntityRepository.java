package az.developia.teacher.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import az.developia.teacher.entity.TeacherEntity;
import az.developia.teacher.exception.OurException;

public class TeacherEntityRepository {

	public void addData(TeacherEntity teacher) {
		if (teacher.getName().length() > 50) {
			throw new OurException("Ad max 50 simvol ola biler");
		}
		if (teacher.getSurname().length() > 50) {
			throw new OurException("soyadi max 50 simvol ola biler");
		}
		
		String insert = "INSERT INTO teachers" + "(name,surname,phone,address,username,password) values" + "('"
				+ teacher.getName() + "','" + teacher.getSurname() + "','" + teacher.getPhone() + "'," + "'"
				+ teacher.getAddress() + "','" + teacher.getUsername() + "','" + teacher.getPassword() + "')";
		
		try {
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/java13_teacher?useSSL=false",
					"root", "012345");
			Statement st = connect.createStatement();
			st.executeUpdate(insert);
			
			connect.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public boolean checkUsernameIfExists(String username ) {
		
		boolean exists = false;
		
		try {
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/java13_teacher?useSSL=false",
					"root", "012345");
			Statement st = connect.createStatement();
			ResultSet set = st.executeQuery("SELECT count(*) FROM  teachers  where username='" + username + "';");
			set.next();
			exists = set.getInt(1)==1?true:false;
			
			connect.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		return exists;
	}
	
	public boolean checkUserIfExists(String username, String password) {
		
		boolean exists = false;
		String query = "SELECT count(*) FROM  teachers  where username= '" + username + "' and password= " + password ;
		try {
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/java13_teacher?useSSL=false",
					"root", "012345");
			Statement st = connect.createStatement();
			ResultSet set = st.executeQuery(query);
			set.next();
			exists = set.getInt(1)==1?true:false;
			
			connect.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		return exists;
	}
	
	
	
}
