package az.developia.teacher.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import az.developia.teacher.entity.TeacherGroupEntity;

public class TeacherGroupRepository {

	public void add(TeacherGroupEntity groups) {

		String query = "INSERT INTO teacher_groups " + "(group_name,teacher_id,register_date,payment_date) values "
				+ "('" + groups.getName() + "','" + groups.getTeacherId() + "','" + groups.getRegisterDate() + "','"
				+ groups.getPaymentDate() + "')";

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
	
	public TeacherGroupEntity findGroupById(Integer id) {
		TeacherGroupEntity entity = new TeacherGroupEntity();
		
		String query = "SELECT * FROM teacher_groups where teacher_id = " + id;
		
		try {
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/java13_teacher?useSSL=false",
					"root", "012345");
			Statement state = connect.createStatement();
			ResultSet st = state.executeQuery(query);
			
			if (st.next()) {
				entity.setId(st.getInt("id"));
				entity.setName(st.getString("group_name"));
				entity.setTeacherId(st.getInt("teacher_id"));
				entity.setRegisterDate(st.getTimestamp("register_date").toLocalDateTime());
				entity.setPaymentDate(st.getInt("payment_date"));
			}
			
			connect.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return entity;
	}
	
	public ArrayList<TeacherGroupEntity> findGroupAllById(Integer id){
		ArrayList<TeacherGroupEntity> entities = new ArrayList<>();
		
		String query = "SELECT * FROM teacher_groups where teacher_id = " + id;
		
		try {
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/java13_teacher?useSSL=false",
					"root", "012345");
			Statement state = connect.createStatement();
			ResultSet rs = state.executeQuery(query);
			
			while (rs.next()) {
				TeacherGroupEntity entity = new TeacherGroupEntity();
				entity.setId(rs.getInt("id"));
				entity.setName(rs.getString("group_name"));
				entity.setTeacherId(rs.getInt("teacher_id"));
				entity.setRegisterDate(rs.getTimestamp("register_date").toLocalDateTime());
				entity.setPaymentDate(rs.getInt("payment_date"));
				entities.add(entity);
			}
			
			connect.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return entities;
	}
	
	public void Delete(Integer id) {
		String query = "delete from teacher_groups where id=" + id;
		
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
}
