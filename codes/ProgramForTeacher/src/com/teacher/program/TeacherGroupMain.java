package com.teacher.program;


import com.teacher.program.entity.TeacherEntity;
import com.teacher.program.entity.TeacherGroupEntity;
import com.teacher.program.exception.OurRuntimeException;
import com.teacher.program.repository.TeacherGroupRepository;
import com.teacher.program.repository.TeacherRepository;

public class TeacherGroupMain {

	public static void main(String[] args) {
		

		//TeacherGroupEntity teacherGroup = new TeacherGroupEntity(null, "A1", null, 15);
		
		
		TeacherGroupRepository teacherGroupRepo = new TeacherGroupRepository();
		try {
			teacherGroupRepo.findById(16);
			teacherGroupRepo.deleteById(1);
		} catch (OurRuntimeException e) {
			System.out.println(e.getOurMessage());
		}
		
		
		
		
		
		

	}

}
