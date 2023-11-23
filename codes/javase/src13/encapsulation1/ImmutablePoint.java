package encapsulation1;

public class ImmutablePoint {
     private final String x;
     private final String y;
     
     
	public ImmutablePoint(String x, String y) {
		
		this.x = x;
		this.y = y;
	}


	public String getX() {
		return x;
	}


	public String getY() {
		return y;
	}


	
     
     
}
