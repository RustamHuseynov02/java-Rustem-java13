package az.developia.course.exception;

import org.springframework.validation.BindingResult;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OurRuntimeException extends RuntimeException {

       private BindingResult br;
       
       public OurRuntimeException(BindingResult br, String message) {
    	   super(message);
    	   this.br = br;
       }
}
