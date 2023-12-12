package com.teacher.program;


import java.time.LocalDateTime;

import com.teacher.program.entity.TeacherEntity;
import com.teacher.program.entity.TeacherGroupEntity;
import com.teacher.program.exception.OurRuntimeException;
import com.teacher.program.repository.TeacherGroupRepository;
import com.teacher.program.repository.TeacherRepository;

public class TeacherGroupMain {

	public static void main(String[] args) {
		

		//TeacherGroupEntity teacherGroup = new TeacherGroupEntity(null, "A1", 1, LocalDateTime.of(2022, 12, 15, 20,20), 15);
		
		
		TeacherGroupRepository teacherGroupRepo = new TeacherGroupRepository();
		try {
			//teacherGroupRepo.createGroup(teacherGroup);
			teacherGroupRepo.findById(16);
			teacherGroupRepo.deleteById(1);
		} catch (OurRuntimeException e) {
			System.out.println(e.getOurMessage());
		}
		
		
		
		
		
		

	}

}
