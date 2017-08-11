package org.sebek.struts1.example.ajax;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ajaxtags.helpers.AjaxXmlBuilder;
import org.sebek.struts1.example.dto.StateDTO;
import org.sebek.struts1.example.dto.StateXmlDTO;
import org.sebek.struts1.example.dto.StatesXmlDTO;
import org.sebek.struts1.example.service.StateDetailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StateCodesAjax {
	

	/**
	 * Used by <ajax:select> tag in jsp..... executes but data is not displayed.  If The RequestBody
	 * annotation is removed then spring throws a "ServletException: Could not resolve view with name ''" then
	 * displays the xml needed to build the options in the target select.
	 * 
	 * @param request
	 * @param response
	 * @return String containing XML and ajaxtags tags
	 */
	@RequestMapping(value="/ajax/tags/getStates",method=RequestMethod.GET)
	@ResponseBody
	public String getStateCodesAjaxTags(HttpServletRequest request, HttpServletResponse response) {
		
		/*
		 * Just showing how to retrieve parameter from HttpSerlvetRequest.
		 * Not need for what the method is doing.
		 */
		String jobId = request.getParameter("jobId");
		
		// Included with the Ajaxtags library.  Other options are available
		AjaxXmlBuilder builder = new AjaxXmlBuilder();
		
		builder.addItem("Select a state",jobId);
		
		List<StateDTO> stateCodes = StateDetailService.getInstance().getStateList();
		for (StateDTO state : stateCodes) {
			builder.addItem(state.getName(),state.getAbrv());
		}
		return builder.toString();
	}
	
	/**
	 * Used by JQuery.ajax call to return JSON Object for displaying as options in html select
	 * Used by JQuery DisplayTables to return JSON object for displaying in table
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/ajax/json/getStates", method=RequestMethod.GET)
	@ResponseBody
	public List<StateDTO> getStateCodesJSON(HttpServletRequest request, HttpServletResponse response) {

		/*
		 * Just showing how to retrieve parameter from HttpSerlvetRequest.
		 * Not need for what the method is doing.
		 */
		@SuppressWarnings("unused")
		String jobId = request.getParameter("jobId");
		
		return StateDetailService.getInstance().getStateList();

	}
	
	/**
	 * Used by JQuery.ajax call to return XML
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/ajax/xml/getStates",method=RequestMethod.GET)
	@ResponseBody
	public StatesXmlDTO getStateCodesXML(HttpServletRequest request, HttpServletResponse response) {
		
		/*
		 * Just showing how to retrieve parameter from HttpSerlvetRequest.
		 * Not need for what the method is doing.
		 */
		@SuppressWarnings("unused")
		String jobId = request.getParameter("jobId");
		
		StatesXmlDTO states = new StatesXmlDTO();

		//need to convert StateDTO to StateXmlDTO
		List<StateDTO> stateCodes = StateDetailService.getInstance().getStateList();
		for (StateDTO stateDTO : stateCodes) {
			StateXmlDTO state = new StateXmlDTO(stateDTO);
			states.getStates().add(state);
		}
		return states;
	}
	
	@RequestMapping(value="/ajax/getStateDetailList",method=RequestMethod.GET)
	public List<StateDTO> getStateDetailList(HttpServletRequest request, HttpServletResponse response) {
		
		return StateDetailService.getInstance().getStateList();
	}
}
