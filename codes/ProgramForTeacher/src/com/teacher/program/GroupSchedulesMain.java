package com.teacher.program;

import com.teacher.program.entity.GroupSchedulesEntity;
import com.teacher.program.exception.OurRuntimeException;

public class GroupSchedulesMain {

	public static void main(String[] args) {
		try {
			GroupSchedulesEntity schedulesEntity = new GroupSchedulesEntity(null, 2, 1-3-5);
		} catch (OurRuntimeException e) {
			System.out.println(e.getOurMessage());
		}

	}

}
