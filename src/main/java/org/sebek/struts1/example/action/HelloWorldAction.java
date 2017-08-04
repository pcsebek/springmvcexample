package org.sebek.struts1.example.action;


import org.sebek.struts1.example.form.HelloWorldForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * This class was originally created for use in a struts application
 * The class name or package was not changed from the original so that file compares could be made
 * 
 * To convert to a Spring MVC "controller" class, the following steps have taken place:
 * 		-- @Controller before the class replaces the 'extends Action'
 * 		-- Based on what is defined in the struts configuration file for this action class, a RequestMapping can
 * 				be used for the entire class with more fine grained mappings to each public method
 * 		-- Method that returned ActionForward now String.  NOTE there may be other options within 
 * 				Spring framework.
 * 		-- Methods that accepted ActionMapping, ActionForm, HttpServletRequest, and HttpServletResponse now accept
 * 				Model.  Note there may be other options within Spring framework
 * 		-- Return 'mapping.findForward' now returns appropriate type
 * 
 * https://github.com/pcsebek/struts1example.git
 * 
 * @author PC Sebek
 *
 */
@Controller
public class HelloWorldAction {
	@RequestMapping("/helloWorld") 
	public String execute(Model model) {
			HelloWorldForm helloWorldForm = new HelloWorldForm();
			helloWorldForm.setMessage("HelloWorld! Spring MVC");
			model.addAttribute("helloWorldForm",helloWorldForm);
		return "view.helloWorld";
	}
}
