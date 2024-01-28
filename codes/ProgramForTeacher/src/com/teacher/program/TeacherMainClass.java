package com.teacher.program;

import com.teacher.program.entity.TeacherEntity;
import com.teacher.program.entity.TeacherGroupEntity;
import com.teacher.program.exception.OurRuntimeException;
import com.teacher.program.repository.TeacherRepository;

public class TeacherMainClass {

	public static void main(String[] args) {
		// muəllim frontdan öz məlumatlarını daxil edir və göndərir
		// bu zaman məlumat serverə,controllere daxil olur və
		// bu məlumatlar bazaya yazılmalı olduğuna görə,
		// servisə göndərilir və servisdə repoya gondərir,
		// repoda datada table-nın içinə yazdırır

		TeacherEntity teacher = new TeacherEntity(null, "Kamil", "Memmedov", "0556189999", "Xirdalan City",
				"kamil1", "111222333");
		
		

		// burada entity də olan məlumatları `java13_teacher` datasının içindəki
		// teachers table-na (cədvəl yəni) göndəririk
		// bunun üçün bizə lazım olan kitabxana JDBC-dir 
		// JDBC - Java Data Base Connector
		
		
		TeacherRepository teacherRepo = new TeacherRepository();
		try {
			if(teacherRepo.checkUserNameIfExists(teacher.getUserName())) {
				System.out.println("Bu username istifade olunub");
			}
			else {
				teacherRepo.add(teacher);
			}
			
		} catch (OurRuntimeException e) {
			System.out.println(e.getOurMessage());
		}
	}

}