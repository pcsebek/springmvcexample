package org.sebek.struts1.example.ajax;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sebek.struts1.example.dto.JobDTO;
import org.sebek.struts1.example.service.JobService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
public class JobListAjaxAction {
	
	private static String OPTION_STRING_FORMAT = "<option value=\"%s\">%s</option>";
	
	@RequestMapping("/do//ajax/getJobList")
	public ModelAndView execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	
		List<JobDTO> theList = JobService.getInstance().getJobList();
		
		PrintWriter out = response.getWriter();
		for (JobDTO record : theList) {
			out.print(String.format(OPTION_STRING_FORMAT,record.getId(),record.getDescription()));
			out.flush();
		}
		return null;
	}
}
