package org.sebek.struts1.example.dto;

public class StateDTO {

	private String abrv;
	private String name;
	private String capital;
	private int stateHood;
	private long population;
	
	public StateDTO() {
		// no parameter constructor
	}
	
	public StateDTO(String abrv, String name, String capital, int stateHood, long population) {
		this.abrv = abrv;
		this.name = name;
		this.capital = capital;
		this.stateHood = stateHood;
		this.population = population;
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

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public int getStateHood() {
		return stateHood;
	}

	public void setStateHood(int stateHood) {
		this.stateHood = stateHood;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}
}
