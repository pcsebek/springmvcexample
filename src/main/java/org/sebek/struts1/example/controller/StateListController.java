package org.sebek.struts1.example.controller;

import java.util.List;

import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.PreparerException;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;
import org.sebek.struts1.example.dto.StateDTO;
import org.sebek.struts1.example.service.StateDetailService;

/**
 * Dead code for now - need more research
 * 
 * @author phil
 *
 */
public class StateListController implements ViewPreparer {

	@Override
	public void execute(Request request, AttributeContext attributeContext) 
		throws PreparerException {
		
		List<StateDTO> states = StateDetailService.getInstance().getStateList();
		attributeContext.putAttribute("stateList",  new Attribute(states));
		
	}

}
