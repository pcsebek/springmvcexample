package org.sebek.struts1.example.form;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.sebek.struts1.example.dto.JobDTO;
import org.sebek.struts1.example.validation.constraint.CustomNotBlank;

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
public class EmployeeForm{

	private String selectedId;
	private String employeeId;
	
	/* https://raymondhlee.wordpress.com/2014/07/26/including-field-value-in-validation-message-using-spring-validation-framework-for-jsr-303/ */
	// produces "Last Name lastName is required" note the {0} is replaced by attribute name
	// ToDo: look at Hibernate Validator to see if a label from properties file can be substituted for the attribute name in error message.
	@NotBlank
	private String lastName;
	
	@CustomNotBlank(arg0="{label.first.name}")
	@NotBlank
	private String firstName;
	
	private String currentJobId;
	private String priorJobId;
	
	@NotBlank(message="{errors.required}")
	@NotEmpty(message="{label.salary} {errors.required}")
	private String salary;
	
	private String stateCd;
	private String stateCd2;
	private String stateCd3;
	
	private String stateTypeCd;
	
	List<JobDTO> previousJobs = new ArrayList<JobDTO>();	
	List<JobDTO> jobList = new ArrayList<JobDTO>();
	

	public String getSelectedId() {
		return selectedId;
	}
	
	public void setSelectedId(String selectedId) {
		this.selectedId = selectedId;
	}
	
	public String getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getCurrentJobId() {
		return currentJobId;
	}

	public void setCurrentJobId(String currentJobId) {
		this.currentJobId = currentJobId;
	}

	public String getPriorJobId() {
		return priorJobId;
	}
	
	public void setPriorJobId(String priorJobId) {
		this.priorJobId = priorJobId;
	}
	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	public String getStateCd() {
		return stateCd;
	}
	
	public void setStateCd(String stateCd) {
		this.stateCd = stateCd;
	}
	
	public String getStateCd2() {
		return stateCd2;
	}
	
	public void setStateCd2(String stateCd) {
		this.stateCd2 = stateCd;
	}
	
	public String getStateCd3() {
		return stateCd3;
	}
	
	public void setStateCd3(String stateCd) {
		this.stateCd3 = stateCd;
	}
	
	public String getStateTypeCd() {
		return stateTypeCd;
	}
	
	public void setStateTypeCd(String stateTypeCd) {
		this.stateTypeCd = stateTypeCd;
	}
	
	public List<JobDTO> getPreviousJobs() {
		return previousJobs;
	}

	public void setPreviousJobs(List<JobDTO> previousJobs) {
		this.previousJobs = previousJobs;
	}

	public List<JobDTO> getJobList() {
		return jobList;
	}

	public void setJobList(List<JobDTO> jobList) {
		this.jobList = jobList;
	}
	
	public void clearFields() {
		selectedId = null;
		employeeId = null;
		lastName = null;
		firstName = null;
		currentJobId = null;
		priorJobId = null;
		salary = null;
		
		previousJobs = new ArrayList<JobDTO>();	

	}
}
