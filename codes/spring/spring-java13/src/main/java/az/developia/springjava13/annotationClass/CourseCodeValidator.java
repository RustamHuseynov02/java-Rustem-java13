package az.developia.springjava13.annotationClass;



import az.developia.springjava13.annotation.myAnnotation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;



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
