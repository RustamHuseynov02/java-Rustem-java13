package com.teacher.program.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.teacher.program.entity.TeacherEntity;
import com.teacher.program.entity.TeacherGroupEntity;
import com.teacher.program.exception.OurRuntimeException;

public class TeacherGroupRepository {

	// muellimin qrup yaratmasi
	public void createGroup(TeacherGroupEntity teacherGroup) {
		String query = "INSERT INTO teacher_groups" + "(group_name,teacher_id,register_date,payment_date) values" + "('"
				+ teacherGroup.getName() + "','" + teacherGroup.getTeacherId() + "','" + teacherGroup.getRegisterDate()
				+ "','" + teacherGroup.getPaymentDate() + "')";

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

	// qruplari id koduna gore goster

	public TeacherGroupEntity findById(Integer id) {
		String query = "SELECT * FROM teacher_groups where teacher_id = " + id;
		TeacherGroupEntity entity = new TeacherGroupEntity();
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
		if (entity.getId() == null) {
			throw new OurRuntimeException("Gonderilen id-e uygun mellim tapilmadi id =" + id);
		}

		return entity;
	}

	public void deleteById(Integer id) {
		String query = "delete from teacher_groups where id =" + id;
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
