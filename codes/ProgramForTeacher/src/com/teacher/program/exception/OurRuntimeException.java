package com.teacher.program.exception;

public class OurRuntimeException extends RuntimeException {
     private String OurMessage;
     
     
     
     public String getOurMessage() {
		return OurMessage;
	}



	public OurRuntimeException(String message) {
    	 this.OurMessage = message;
     }



	
}
