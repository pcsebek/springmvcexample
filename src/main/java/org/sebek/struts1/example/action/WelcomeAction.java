package org.sebek.struts1.example.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 * This class was originally created for use in a struts application
 * The class name or package was not changed from the original so that file compares could be made
 * 
 * To convert to a Spring MVC "controller" class, the following steps have taken place:
 * 		-- @Controller before the class replaces the 'extends Action'
 * 		-- Based on what is defined in the struts configuration file for this action class, a RequestMapping can
 * 				be used for the entire class with more fine grained mappings to each public method
 * 		-- Methods that returned ActionForward now return ModelAndView.  NOTE there may be other options within 
 * 				Spring framework.
 * 		-- Methods that accepted ActionMapping, ActionForm, HttpServletRequest, and HttpServletResponse now accept
 * 				HttpServletRequest, HttpServletResponse, annotated form, BindingResult
 * 		-- Return 'mapping.findForward' now returns appropriate type
 * 
 * https://github.com/pcsebek/struts1example.git
 * 
 * @author PC Sebek
 *
 */
@Controller
public class WelcomeAction {
	
	@RequestMapping("/welcome")
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
//		return mapping.findForward("success");
		
		// need to figure out apache tiles so below is temporary
//		return new ModelAndView("welcome","screenName","Welcome to Spring MVC");
		return new ModelAndView(".view.welcome");
		
	}
}
