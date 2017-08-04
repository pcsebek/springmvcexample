package org.sebek.struts1.example.validation.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;

public class CustomNotBlankValidator implements ConstraintValidator<CustomNotBlank, String> {

	private CustomNotBlank constraint;
	
	@Override
	public void initialize(CustomNotBlank constraintAnnotation) {
		this.constraint = constraintAnnotation;
	}
	
	@Override
	public boolean isValid(String testValue, ConstraintValidatorContext context) {

		boolean isValid = true;
		if (testValue == null || testValue.length() < 1) {
			
			HibernateConstraintValidatorContext hibernateContext =
					context.unwrap(HibernateConstraintValidatorContext.class);
			hibernateContext.disableDefaultConstraintViolation();
			
			String message;
			if (constraint.message() == null && constraint.message().length() > 0) {
				message = constraint.message();
			}
			else {
				message = hibernateContext.getDefaultConstraintMessageTemplate();
			}
			String value = constraint.arg0();
			if (value == null || value.isEmpty()) {
				value = " ";
			}
			
			
// produced CustomeNotBlank default message for field {fieldLabel}
//			hibernateContext.addExpressionVariable("fieldLabel", value)
//				.buildConstraintViolationWithTemplate(message)
//				.addConstraintViolation();

// produced CustomNotBlank default message for field {label.first.name}	
// if the 'value' is actually a message key then translation of the message
// message key must take place before being added as a parameter.
			hibernateContext.addMessageParameter("fieldLabel", value);


			hibernateContext.buildConstraintViolationWithTemplate(message)
			.addConstraintViolation();
			isValid = false;
		}
		return isValid;
	}

}
