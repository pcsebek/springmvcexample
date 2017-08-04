package org.sebek.struts1.example.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.sebek.struts1.example.dto.EmployeeDTO;
import org.sebek.struts1.example.dto.JobDTO;
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
@RequestMapping("/employeeUpdate")
public class EmployeeUpdateAction {
	
	/**
	 * Tied to the Save button
	 * @param request
	 * @param response
	 * @param employeeForm
	 * @param bindingResult
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params="save",method=RequestMethod.POST)
	public String save (HttpServletRequest request, HttpServletResponse response,
			@Valid @ModelAttribute("employeeForm") EmployeeForm employeeForm,
			BindingResult bindingResult) throws Exception {
		
		if (!bindingResult.hasErrors()) {
			updateData(employeeForm);
		}
//		return new ModelAndView(".view.employee","employeeForm",employeeForm);
		return ".view.employee";
	}
	
	/**
	 * Tied to the Save And Add button
	 * @param request
	 * @param respone
	 * @param employeeForm
	 * @param bindingResult
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params="saveAndAdd",method=RequestMethod.POST)
	public String saveAndAdd(HttpServletRequest request, HttpServletResponse respone,
			@Valid @ModelAttribute("employeeForm") EmployeeForm employeeForm,
			BindingResult bindingResult, Model model) throws Exception {
		
		if (bindingResult.hasErrors()) {
			// do nothing
		}
		else {
			updateData(employeeForm);
			
			// Clear form fields and refresh job list
			employeeForm.clearFields();
			employeeForm.setJobList(JobService.getInstance().getJobList());
			model.addAttribute("employeeForm", employeeForm);
		}
		return ".view.employee";
	}
	
	/**
	 * Tied to the Delete button
	 * 
	 * @param request
	 * @param respone
	 * @param employeeForm
	 * @param bindingResult
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params="delete",method=RequestMethod.POST)
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse respone,
			@ModelAttribute("employeeForm") EmployeeForm employeeForm,
			BindingResult bindingResult) throws Exception {
		
		
		if (employeeForm.getEmployeeId() != null && !employeeForm.getEmployeeId().isEmpty()) {
			
			Integer employeeId = Integer.valueOf(employeeForm.getEmployeeId());
			EmployeeService.getInstance().deleteEmployeeData(employeeId);
		}
		employeeForm.clearFields();
		return new ModelAndView(".view.employee.summary");
	}

	/**
	 * populates the DTO with action form data and calls "service" to update
	 * @param employeeForm
	 * @throws Exception
	 */
	private void updateData(EmployeeForm employeeForm) throws Exception {

		Integer employeeId;
		EmployeeDTO employeeDTO;
		
		if (employeeForm.getEmployeeId() == null || employeeForm.getEmployeeId().isEmpty()) {
			
			// Add
			employeeId = null;
			employeeDTO = new EmployeeDTO();
		}
		
		else {
			// Update
			employeeId = Integer.valueOf(employeeForm.getEmployeeId());
			employeeDTO = EmployeeService.getInstance().getEmployeeData(employeeId);
		}
		
		employeeDTO.setFirstName(employeeForm.getFirstName());
		employeeDTO.setLastName(employeeForm.getLastName());
		
		if (employeeForm.getSalary() == null || employeeForm.getSalary().isEmpty()) {
			employeeDTO.setSalary(null);
		}
		else {
			employeeDTO.setSalary(Integer.valueOf(employeeForm.getSalary()));
		}
		
		List<JobDTO> previousJobs = employeeDTO.getPreviousJobs();
		
		if (employeeForm.getCurrentJobId() != null && !employeeForm.getCurrentJobId().isEmpty()) {
			
			// Initially prior job ID will be null/empty so set it to current job ID
			if (employeeForm.getPriorJobId() == null || employeeForm.getPriorJobId().isEmpty()) {
				employeeForm.setPriorJobId(employeeForm.getCurrentJobId());
			}
			
			// Current job change so add to previous job list and set prior job ID to current job ID
			if (!employeeForm.getCurrentJobId().equals(employeeForm.getPriorJobId())) {
				JobDTO priorJob = JobService.getInstance().getJobById(employeeForm.getPriorJobId());
				if (priorJob != null) {
					
					if (previousJobs == null) {
						previousJobs = new ArrayList<JobDTO>();
					}
					previousJobs.add(priorJob);
					employeeForm.setPriorJobId(employeeForm.getCurrentJobId());
				}
			}
		}
		
		employeeDTO.setPreviousJobs(previousJobs);
		employeeDTO.setJob(JobService.getInstance().getJobById(employeeForm.getCurrentJobId()));

		Integer id = EmployeeService.getInstance().saveEmployeeData(employeeDTO);
		
		employeeForm.setEmployeeId(id == null ? null : id.toString());
		employeeForm.setPreviousJobs(employeeDTO.getPreviousJobs());
		employeeForm.setJobList(JobService.getInstance().getJobList());
	}
}
