package org.sebek.struts1.example.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class goes with the getStateCodesXML in the StateCodesAjax class
 * @author phil
 *
 */
@XmlRootElement(name="state-list")
public class StatesXmlDTO {
	
	List<StateXmlDTO> states = new ArrayList<StateXmlDTO>();

	public List<StateXmlDTO> getStates() {
		return states;
	}

	@XmlElement(name="state")
	public void setStates(List<StateXmlDTO> states) {
		this.states = states;
	}
}
