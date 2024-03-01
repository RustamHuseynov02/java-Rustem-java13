package az.developia.springjava13.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import az.developia.springjava13.annotationClass.CourseCodeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = CourseCodeValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD } )
@Retention(RetentionPolicy.RUNTIME)
public @interface myAnnotation {
	
	public String value() default "ov";

	String message() default "Bu surname duzgun qeyd olunmuyub";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
