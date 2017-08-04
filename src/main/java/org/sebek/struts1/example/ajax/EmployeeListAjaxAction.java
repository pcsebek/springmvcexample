package org.sebek.struts1.example.ajax;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sebek.struts1.example.dto.EmployeeDTO;
import org.sebek.struts1.example.service.EmployeeService;
import org.sebek.struts1.example.utils.EmployeeComparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This class was originally created for use in a struts application
 * The class name or package was not changed from the original so that file compares could be made
 * 
 * To convert to a Spring MVC "controller" class, the following steps have taken place:
 * 		-- @Controller before the class replaces the 'extends Action'
 * 		-- Methods that returned ActionForward now return ModelAndView.  NOTE there may be other options within 
 * 				Spring framework.
 * 		-- Methods that accepted ActionMapping, ActionForm, HttpServletRequest, and HttpServletResponse now accept
 * 				HttpServletRequest, HttpServletResponse, annotated form, BindingResult
 * 
 * https://github.com/pcsebek/struts1example.git
 * 
 * @author PC Sebek
 *
 */
@Controller
public class EmployeeListAjaxAction {
	
	private static String OPTION_STRING_FORMAT = "<option value=\"%s\">%s</option>";
	
	/**
	 * Method called via JQuery.ajax.
	 * Two options to make this work:
	 * 
	 * Option 1 is the same approach as used in the Struts version of this project.   Use the PrintWriter
	 * object from HttpServletResponse to format the output with HTML tags and have the JavaScript append 
	 * the formatted string to the <select> tag.
	 * 
	 * Option 2 uses the @ResponseBody tag and returns a String where the JavaScript appends the formatted
	 * string to the <select> tag
	 * 
	 * @param request - HttpServletRequest
	 * @param response - HttpServletResponse
	 * @throws Exception
	 */
	@RequestMapping("/ajax/getEmployeeList")
	//@ResponseBody	// option 2 plus method return type of String
	public void execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			
		List<EmployeeDTO> theList = EmployeeService.getInstance().getEmployees();
				
		// Sort the list
		theList.sort(new EmployeeComparator());

		/*
		 * Option 1. -- javascript needs to append result to the correct tag in the JSP
		 */
		PrintWriter out = response.getWriter();
		for (EmployeeDTO record : theList) {
			out.print(String.format(OPTION_STRING_FORMAT,record.getId(),record.getFormattedName()));
			out.flush();
		}
		
		/*
		 * Option 2
		 *
		StringBuilder result = new StringBuilder();
		for (EmployeeDTO record : theList) {
			result.append(String.format(OPTION_STRING_FORMAT,record.getId(),record.getFormattedName()));
		}
		return result.toString();
		*/
	}
}
