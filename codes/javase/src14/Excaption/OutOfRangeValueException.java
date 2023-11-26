package Excaption;
import java.lang.IllegalArgumentException;


public class OutOfRangeValueException extends IllegalArgumentException {
      public OutOfRangeValueException(String message) {
    	  super(message);
      }
}
