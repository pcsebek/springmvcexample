package org.sebek.struts1.example.dto;

public class StateDTO {

	private String abrv;
	private String name;
	
	public StateDTO() {
		// no parameter constructor
	}
	
	public StateDTO(String abrv, String name) {
		this.abrv = abrv;
		this.name = name;
	}

	public String getAbrv() {
		return abrv;
	}

	public void setAbrv(String abrv) {
		this.abrv = abrv;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
