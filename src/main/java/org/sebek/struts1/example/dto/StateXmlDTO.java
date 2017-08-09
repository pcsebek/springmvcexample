package org.sebek.struts1.example.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class goes with the getStateCodesXML in the StateCodesAjax class
 * @author phil
 *
 */
@XmlRootElement(name="state")
public class StateXmlDTO {

	private String abrv;
	private String name;
	
	public StateXmlDTO() {
		// no parameter constructor
	}
	
	public StateXmlDTO(String abrv, String name) {
		this.abrv = abrv;
		this.name = name;
	}
	
	public StateXmlDTO(StateDTO stateDTO) {
		this.abrv = stateDTO.getAbrv();
		this.name = stateDTO.getName();
	}

	public String getAbrv() {
		return abrv;
	}

	@XmlElement
	public void setAbrv(String abrv) {
		this.abrv = abrv;
	}

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
}
