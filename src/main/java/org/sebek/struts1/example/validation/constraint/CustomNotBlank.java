package org.sebek.struts1.example.validation.constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = CustomNotBlankValidator.class)
@Documented
public @interface CustomNotBlank {
	
	String message() default "{org.sebek.struts1.example.CustomNotBlank.message}";
	
	Class<?>[] groups() default { };
	
	Class<? extends Payload>[] payload() default { };
	
	String arg0();

}
