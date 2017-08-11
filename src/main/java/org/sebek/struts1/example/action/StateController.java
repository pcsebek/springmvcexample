package org.sebek.struts1.example.action;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sebek.struts1.example.dto.StateDTO;
import org.sebek.struts1.example.service.StateDetailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class StateController {

	@RequestMapping("/states")
	public String getStateDetailsList(HttpServletRequest request, HttpServletResponse response,
									 Model model) throws JsonGenerationException, JsonMappingException, IOException {

		List<StateDTO> theList = StateDetailService.getInstance().getStateList();
		model.addAttribute("stateList",theList);
		
		// Logic to create list of json objects for use by JQuery DataTables
		ObjectMapper objectMapper = new ObjectMapper();
		model.addAttribute("stateList2",
						   objectMapper.writeValueAsString(theList));
		

		return "view.state.detail.list";
	}
	
	/**
	 * This method is intended to be used by the requestURI attribute of 
	 * display:table tag.  The intent is for custom sorting and paginating
	 * the data in the display:table.  More search is required to determine
	 * how this needs to work.  Suspicions are a class from the displaytag 
	 * library needs to be "extended" or "implemented"
	 * 
	 * @param request
	 * @param response
	 * @param stateList
	 */
	@RequestMapping(value="/states/getList", method=RequestMethod.GET)
	public void getList(HttpServletRequest request, HttpServletResponse response,
						@ModelAttribute("stateList") List<StateDTO> stateList) {
		
		Enumeration<String> attributes = request.getAttributeNames();
		stateList.addAll(StateDetailService.getInstance().getStateList());
	}
	
}
