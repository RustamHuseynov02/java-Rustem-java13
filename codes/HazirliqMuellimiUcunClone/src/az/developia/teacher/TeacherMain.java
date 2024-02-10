package az.developia.teacher;

import az.developia.teacher.entity.TeacherEntity;
import az.developia.teacher.exception.OurException;
import az.developia.teacher.repository.TeacherEntityRepository;

public class TeacherMain {

	public static void main(String[] args) {
		TeacherEntity teacher = new TeacherEntity(null,"Haci", "Haciyev", "050", "London", "haci0", "31");

		
		//
		
		
		TeacherEntityRepository repo = new TeacherEntityRepository();
		try {
			if (repo.checkUsernameIfExists(teacher.getUsername())) {
				System.out.println("bu username istifade olunub");
			}
			else {
				repo.addData(teacher);
			}
			
			
		} catch (OurException e) {
			System.out.println(e.getOurMessage());
		}
		
		if (repo.checkUserIfExists("haci0", "31")) {
			System.out.println("Login olundu");
		}
		else {
			System.out.println("basarisiz");
		}
	
	}

}
