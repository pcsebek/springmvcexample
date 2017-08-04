package org.sebek.struts1.example.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sebek.struts1.example.dto.EmployeeDTO;
import org.sebek.struts1.example.form.EmployeeForm;
import org.sebek.struts1.example.service.EmployeeService;
import org.sebek.struts1.example.service.JobService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@RequestMapping("/employee")
public class EmployeeAction {
	
	/**
	 * Method tied to the input type button name add
	 * @param request
	 * @param response
	 * @param employeeForm
	 * @param bindingResult
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params="add", method=RequestMethod.GET)
	public ModelAndView add (HttpServletRequest request, HttpServletResponse response,
							@ModelAttribute("employeeForm") EmployeeForm employeeForm,
							BindingResult bindingResult) throws Exception {
		
		employeeForm.clearFields();
		employeeForm.setJobList(JobService.getInstance().getJobList());
		
		return new ModelAndView(".view.employee","employeeForm",employeeForm);
	}
	
	/**
	 * Method tied to the input type button name display
	 * @param request
	 * @param response
	 * @param employeeForm
	 * @param bindingResult
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params="display", method=RequestMethod.GET)
	public ModelAndView display (HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("employeeForm") EmployeeForm employeeForm,
			BindingResult bindingResult) throws Exception {
		
		String employeeIdStr = determineEmployeeIdToUse(request, employeeForm);
		
		if (employeeIdStr == null || employeeIdStr.isEmpty()) {
			
			if (employeeForm.getEmployeeId() == null)
			employeeForm.clearFields();
		}
		else {
			Integer employeeId = Integer.valueOf(employeeIdStr);
			EmployeeDTO employeeDTO = EmployeeService.getInstance().getEmployeeData(employeeId);
			populateForm(employeeForm, employeeDTO);
		}
		employeeForm.setJobList(JobService.getInstance().getJobList());
		return new ModelAndView(".view.employee","employeeForm",employeeForm);
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/summary", method=RequestMethod.GET)
	public String summary (Model model) {
		
		EmployeeForm employeeForm = new EmployeeForm();
		model.addAttribute("employeeForm",employeeForm);
		return (".view.employee.summary");
	}
	
	private String determineEmployeeIdToUse(HttpServletRequest request, EmployeeForm form) {
		
		String tempId = request.getParameter("employeeId");
		tempId = (tempId == null || tempId.isEmpty() ? form.getEmployeeId() : tempId);
		tempId = (tempId == null || tempId.isEmpty() ? form.getSelectedId() : tempId);
		return tempId;
	}
	
	
	private void populateForm(EmployeeForm form, EmployeeDTO dto) {
		form.setCurrentJobId((dto.getJob() == null ? null : dto.getJob().getId()));
		form.setEmployeeId(dto.getId() == null ? null : dto.getId().toString());
		form.setFirstName(dto.getFirstName());
		form.setLastName(dto.getLastName());
		form.setPreviousJobs(dto.getPreviousJobs());
		form.setSalary((dto.getSalary() == null ? null : dto.getSalary().toString()));
		form.setPriorJobId(form.getCurrentJobId());
	}
}
