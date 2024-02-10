package az.developia.teacher;

import java.time.LocalDateTime;

import az.developia.teacher.entity.TeacherGroupEntity;
import az.developia.teacher.exception.OurException;
import az.developia.teacher.repository.TeacherGroupRepository;

public class TeacherGroupMain {
	public static void main(String[] args) {
          TeacherGroupEntity groupEntity = new TeacherGroupEntity(null, "Sql learn", 21, LocalDateTime.now(), 1);
          
          
          TeacherGroupRepository groupRepo = new TeacherGroupRepository();
          
          try {
			//groupRepo.add(groupEntity);
        	//System.out.println(groupRepo.findGroupById(21));
        	//System.out.println(groupRepo.findGroupAllById(21));
        	groupRepo.Delete(2);
        	  
		} catch (OurException e) {
			System.out.println(e.getOurMessage());
		}
	}
}
