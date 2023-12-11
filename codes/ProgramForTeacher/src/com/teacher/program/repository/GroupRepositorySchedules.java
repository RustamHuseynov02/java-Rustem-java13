package com.teacher.program.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.teacher.program.entity.GroupSchedulesEntity;


public class GroupRepositorySchedules {
	
	public void addSchedules(GroupSchedulesEntity groupSchedules) {
		String query = "INSERT INTO group_schedules" + "(group_id,day,hour) values" + "('"
				+ groupSchedules.getGroupId() + "','" + groupSchedules.getDay() + "','" + groupSchedules.getHour()
				+ "')";

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
