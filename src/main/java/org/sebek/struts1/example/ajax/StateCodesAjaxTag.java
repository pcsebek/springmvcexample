package org.sebek.struts1.example.ajax;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ajaxtags.helpers.AjaxXmlBuilder;
import org.ajaxtags.servlets.BaseAjaxServlet;
import org.sebek.struts1.example.dto.StateDTO;
import org.sebek.struts1.example.service.StateDetailService;

/**
 * This servlet extends the org.ajaxtags.servlets.BaseAjaxServlet and is not "controlled"
 * by Spring MVC.  This class is called by an <ajax:select> tag in a JSP.  A mapping in the
 * web.xml is needed.
 * 
 * @author phil
 *
 */
@SuppressWarnings("serial")
public class StateCodesAjaxTag extends BaseAjaxServlet {

	@Override
	public String getXmlContent(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

}
