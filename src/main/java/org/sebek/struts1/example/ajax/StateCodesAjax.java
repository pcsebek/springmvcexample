package org.sebek.struts1.example.ajax;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ajaxtags.helpers.AjaxXmlBuilder;
import org.sebek.struts1.example.dto.StateDTO;
import org.sebek.struts1.example.dto.StateXmlDTO;
import org.sebek.struts1.example.dto.StatesXmlDTO;
import org.sebek.struts1.example.utils.StateComparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StateCodesAjax {
	
	private static final List<StateDTO> stateCodes = new ArrayList<StateDTO>();

	static {
		stateCodes.add(new StateDTO("AK", "Alaska"));
		stateCodes.add(new StateDTO("AL", "Alabama"));
		stateCodes.add(new StateDTO("AZ", "Arizona"));
		stateCodes.add(new StateDTO("AR", "Arkansas"));
		stateCodes.add(new StateDTO("CA", "California"));
		stateCodes.add(new StateDTO("CO", "Colorado"));
		stateCodes.add(new StateDTO("CT", "Connecticut"));
		stateCodes.add(new StateDTO("DE", "Delaware"));
		stateCodes.add(new StateDTO("FL", "Florida"));
		stateCodes.add(new StateDTO("GA", "Georgia"));
		stateCodes.add(new StateDTO("HI", "Hawaii"));
		stateCodes.add(new StateDTO("ID", "Idaho"));
		stateCodes.add(new StateDTO("IL", "Illinois"));
		stateCodes.add(new StateDTO("IN", "Indiana"));
		stateCodes.add(new StateDTO("IA", "Iowa"));
		stateCodes.add(new StateDTO("KS", "Kansas"));
		stateCodes.add(new StateDTO("KY", "Kentucky"));
		stateCodes.add(new StateDTO("LA", "Louisiana"));
		stateCodes.add(new StateDTO("ME", "Maine"));
		stateCodes.add(new StateDTO("MD", "Maryland"));
		stateCodes.add(new StateDTO("MA", "Massachusetts"));
		stateCodes.add(new StateDTO("MI", "Michigan"));
		stateCodes.add(new StateDTO("MN", "Minnesota"));
		stateCodes.add(new StateDTO("MS","Mississippi"));
		stateCodes.add(new StateDTO("MO", "Missouri"));
		stateCodes.add(new StateDTO("MT", "Montana"));
		stateCodes.add(new StateDTO("NE",  "Nebraska"));
		stateCodes.add(new StateDTO("NV", "Nevada"));
		stateCodes.add(new StateDTO("NH", "New Hampshire"));
		stateCodes.add(new StateDTO("NJ", "New Jersey"));
		stateCodes.add(new StateDTO("NM", "New Mexico"));
		stateCodes.add(new StateDTO("NY", "New York"));
		stateCodes.add(new StateDTO("NC", "North Carolina"));
		stateCodes.add(new StateDTO("ND", "North Dakota"));
		stateCodes.add(new StateDTO("OH", "Ohio"));
		stateCodes.add(new StateDTO("OK", "Oklahoma"));
		stateCodes.add(new StateDTO("OR", "Oregon"));
		stateCodes.add(new StateDTO("PA", "Pennsylvania"));
		stateCodes.add(new StateDTO("RI", "Rhode Island"));
		stateCodes.add(new StateDTO("SC", "South Carolina"));
		stateCodes.add(new StateDTO("SD","South Dakota"));
		stateCodes.add(new StateDTO("TN", "Tennessee"));
		stateCodes.add(new StateDTO("TX", "Texas"));
		stateCodes.add(new StateDTO("UT", "Utah"));
		stateCodes.add(new StateDTO("VT", "Vermont"));
		stateCodes.add(new StateDTO("VA", "Virginia"));
		stateCodes.add(new StateDTO("WA", "Washington"));
		stateCodes.add(new StateDTO("WV", "West Virginia"));
		stateCodes.add(new StateDTO("WI", "Wisconsin"));
		stateCodes.add(new StateDTO("WY", "Wyoming"));
		stateCodes.add(new StateDTO("AS", "American Samoa"));
		stateCodes.add(new StateDTO("DC", "District of Columbia"));
		stateCodes.add(new StateDTO("FM", "Federated States of Micronesia"));
		stateCodes.add(new StateDTO("GU", "Guam"));
		stateCodes.add(new StateDTO("MH", "Marshall Islands"));
		stateCodes.add(new StateDTO("MP", "Nortern Mariana Islands"));
		stateCodes.add(new StateDTO("PW", "Palau"));
		stateCodes.add(new StateDTO("PR", "Puerto Rico"));
		stateCodes.add(new StateDTO("VI", "Virgin Islands"));
		stateCodes.add(new StateDTO("AE", "Armed Forces: Africa,Canada,Europe"));
		stateCodes.add(new StateDTO("AA", "Armed Forces Americas"));
		stateCodes.add(new StateDTO("AP", "Armed Forces Pacific"));
	}

	/**
	 * Used by <ajax:select> tag in jsp..... never gets here
	 * @param request
	 * @param response
	 * @return String containing XML and ajaxtags tags
	 */
	@RequestMapping(value="/ajax/tags/getStates",method=RequestMethod.GET)
	public String getStateCodesAjaxTags(HttpServletRequest request, HttpServletResponse response) {
		
		/*
		 * Just showing how to retrieve parameter from HttpSerlvetRequest.
		 * Not need for what the method is doing.
		 */
		String jobId = request.getParameter("jobId");
		
		// Included with the Ajaxtags library.  Other options are available
		AjaxXmlBuilder builder = new AjaxXmlBuilder();
		
		builder.addItem("Select a state",jobId);
		
		for (StateDTO state : stateCodes) {
			builder.addItem(state.getName(),state.getAbrv());
		}
		return builder.toString();
	}
	
	/**
	 * Used by JQuery.ajax call to return JSON Object
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
		
		stateCodes.sort(new StateComparator());
		return stateCodes;
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
		for (StateDTO stateDTO : stateCodes) {
			StateXmlDTO state = new StateXmlDTO(stateDTO);
			states.getStates().add(state);
		}
		return states;
	}
}
