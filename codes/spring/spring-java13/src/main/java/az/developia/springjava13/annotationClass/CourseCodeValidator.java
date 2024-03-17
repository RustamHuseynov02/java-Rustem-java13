package az.developia.springjava13.annotationClass;



import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import az.developia.springjava13.annotation.myAnnotation;



public class CourseCodeValidator implements ConstraintValidator<myAnnotation,String>{

	private String prefix;
	
    
    @Override
    public void initialize(myAnnotation code) {
    	prefix = code.value();
    }
    
    @Override
    public boolean isValid(String code, ConstraintValidatorContext context) {
    	boolean result;
    		if (code !=  null) {
				result = code.endsWith(prefix);
			}
    		else {
    			result = true;
    		}
    	
    	return result;
    }
	
}
