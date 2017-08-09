package org.sebek.struts1.example.utils;

import java.util.Comparator;

import org.sebek.struts1.example.dto.StateDTO;

public class StateComparator implements Comparator<StateDTO>{

	
	@Override
	public int compare(StateDTO state1, StateDTO state2) {
		
		int result;
		if (state1 == null && state2 == null) {
			result = 0;
		}
		else if (state1 == null) {
			result = -1;
		}
		else if (state2 == null) {
			result = 1;
		}
		else if (state1.getName() == null && state2.getName() == null) {
			result = 0;
		}
		else if (state1.getName() == null) {
			result = -1;
		}
		else if (state2.getName() == null) {
			result = 1;
		}
		else {
			int temp = state1.getName().compareToIgnoreCase(state2.getName()); 
			result = (temp < 0 ? -1 : temp > 0 ? 1 : 0);
		}
		return result;
	}


}
