package az.developia.teacher.exception;

public class OurException extends RuntimeException{

	private String OurMessage;
	
	public OurException(String m) {
		this.OurMessage = m;
	}

	public String getOurMessage() {
		return OurMessage;
	}
}
