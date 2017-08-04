package org.sebek.struts1.example.form;

/**
 * This class was originally created for use in a struts application
 * The class name or package was not changed from the original so that file compares could be made
 * 
 * To converting to a Spring MVC 'model' class
 * 		-- Remove the extends ValidatorForm
 * 		-- Since validation is being performed, use the Hiberate validation annotations on the fields
 * 				being validated.  This eliminates the struts content in validation.xml
 * 		 
 * @author PC Sebek
 *
 */
public class HelloWorldForm {

		private String message;

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

}
