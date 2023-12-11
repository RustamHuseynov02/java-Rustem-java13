package com.teacher.program;

import com.teacher.program.exception.OurRuntimeException;
import com.teacher.program.repository.TeacherRepository;

public class TeacherMainLogin {

	public static void main(String[] args) {
		
		TeacherRepository teacherRepo = new TeacherRepository();
		try {
			if(teacherRepo.checkUserIfExists("rustemh01","111222333")) {
				System.out.println("Login oldun");
			}
			else {
                System.out.println("fail");
			}
			
		} catch (OurRuntimeException e) {
			System.out.println(e.getOurMessage());
		}
	}
}
