package org.sebek.struts1.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.sebek.struts1.example.dto.StateDTO;
import org.sebek.struts1.example.utils.StateComparator;

public class StateDetailService {
	
	private static StateDetailService instance = new StateDetailService();
	
	private static SortedMap<String,StateDTO> stateDetailMap =
			new TreeMap<String,StateDTO>();

	static {
		stateDetailMap.put("AK",new StateDTO("AK", "Alaska","Juneau",1959,741894));
		stateDetailMap.put("AL",new StateDTO("AL", "Alabama","Montgomery",1819,4863300));
		stateDetailMap.put("AZ",new StateDTO("AZ", "Arizona","Phoenix",1912,6931071));
		stateDetailMap.put("AR",new StateDTO("AR", "Arkansas","Little Rock",1836,2988248));
		stateDetailMap.put("CA",new StateDTO("CA", "California","Sacramento",1850,39250017));
		stateDetailMap.put("CO",new StateDTO("CO", "Colorado","Denver",1876,5540545));
		stateDetailMap.put("CT",new StateDTO("CT", "Connecticut","Hartford",1788,357452));
		stateDetailMap.put("DE",new StateDTO("DE", "Delaware","Dover",1787,952065));
		stateDetailMap.put("FL",new StateDTO("FL", "Florida","Tallahassee",1845,20612439));
		stateDetailMap.put("GA",new StateDTO("GA", "Georgia","Atlanta",1788,10310371));
		stateDetailMap.put("HI",new StateDTO("HI", "Hawaii","Honolulu",1959,1428557));
		stateDetailMap.put("ID",new StateDTO("ID", "Idaho","Boise",1890,1683140));
		stateDetailMap.put("IL",new StateDTO("IL", "Illinois","Springfield",1818,12801539));
		stateDetailMap.put("IN",new StateDTO("IN", "Indiana","Indianapolis",1816,6633053));
		stateDetailMap.put("IA",new StateDTO("IA", "Iowa","Des Moines",1846,3134693));
		stateDetailMap.put("KS",new StateDTO("KS", "Kansas","Topeka",1861,2907289));
		stateDetailMap.put("KY",new StateDTO("KY", "Kentucky","Frankfort",1792,4436974));
		stateDetailMap.put("LA",new StateDTO("LA", "Louisiana","Baton Rouge",1812,4681666));
		stateDetailMap.put("ME",new StateDTO("ME", "Maine","Augusta",1820,1331479));
		stateDetailMap.put("MD",new StateDTO("MD", "Maryland","Annapolis",1788,6016447));
		stateDetailMap.put("MA",new StateDTO("MA", "Massachusetts","Boston",1788,6811779));
		stateDetailMap.put("MI",new StateDTO("MI", "Michigan","Lansing",1837,9928301));
		stateDetailMap.put("MN",new StateDTO("MN", "Minnesota","Saint Paul",1858,5519952));
		stateDetailMap.put("MS",new StateDTO("MS","Mississippi","Jackson",1817,2988726));
		stateDetailMap.put("MO",new StateDTO("MO", "Missouri","Jefferson City",1821,6093000));
		stateDetailMap.put("MT",new StateDTO("MT", "Montana","Helena",1889,1042520));
		stateDetailMap.put("NE",new StateDTO("NE",  "Nebraska","Lincoln",1867,1907116));
		stateDetailMap.put("NV",new StateDTO("NV", "Nevada","Carson City",1864,2940058));
		stateDetailMap.put("NH",new StateDTO("NH", "New Hampshire","Concord",1788,1334795));
		stateDetailMap.put("NJ",new StateDTO("NJ", "New Jersey","Trenton",1787,8944469));
		stateDetailMap.put("NM",new StateDTO("NM", "New Mexico","Santa Fe",1912,2081015));
		stateDetailMap.put("NY",new StateDTO("NY", "New York","Albany",1788,19745289));
		stateDetailMap.put("NC",new StateDTO("NC", "North Carolina","Raleigh",1789,10146788));
		stateDetailMap.put("ND",new StateDTO("ND", "North Dakota","Bismarck",1889,757952));
		stateDetailMap.put("OH",new StateDTO("OH", "Ohio","Columbus",1803,11646273));
		stateDetailMap.put("OK",new StateDTO("OK", "Oklahoma","Oklahoma City",1907,3923561));
		stateDetailMap.put("OR",new StateDTO("OR", "Oregon","Salem",1859,4093465));
		stateDetailMap.put("PA",new StateDTO("PA", "Pennsylvania","Harrisburg",1787,12784227));
		stateDetailMap.put("RI",new StateDTO("RI", "Rhode Island","Providence",1790,1056426));
		stateDetailMap.put("SC",new StateDTO("SC", "South Carolina","Columbia",1788,4961119));
		stateDetailMap.put("SD",new StateDTO("SD","South Dakota","Pierre",1889,865454));
		stateDetailMap.put("TN",new StateDTO("TN", "Tennessee","Nashville",1796,6651194));
		stateDetailMap.put("TX",new StateDTO("TX", "Texas","Austin",1845,27862596));
		stateDetailMap.put("UT",new StateDTO("UT", "Utah","Salt Lake City",1896,3051217));
		stateDetailMap.put("VT",new StateDTO("VT", "Vermont","Montpelier",1791,624594));
		stateDetailMap.put("VA",new StateDTO("VA", "Virginia","Richmond",1788,8411808));
		stateDetailMap.put("WA",new StateDTO("WA", "Washington","Olympia",1889,7288000));
		stateDetailMap.put("WV",new StateDTO("WV", "West Virginia","Charleston",1863,1831102));
		stateDetailMap.put("WI",new StateDTO("WI", "Wisconsin","Madison",1848,5778708));
		stateDetailMap.put("WY",new StateDTO("WY", "Wyoming","Cheyenne",1890,585501));
		stateDetailMap.put("AS",new StateDTO("AS", "American Samoa","Pago Pago",1899,54343));
		stateDetailMap.put("DC",new StateDTO("DC", "Washington, D.C.",null,1790,681170));
		stateDetailMap.put("FM",new StateDTO("FM", "Federated States of Micronesia","Palikir",1947,104433));
		stateDetailMap.put("GU",new StateDTO("GU", "Guam","Hagatna", 1898,161785));
		stateDetailMap.put("MH",new StateDTO("MH", "Marshall Islands","Majuro",1947,52994));
		stateDetailMap.put("MP",new StateDTO("MP", "Northern Mariana Islands","Saipan",1947,52344));
		stateDetailMap.put("PW",new StateDTO("PW", "Palau","Ngerulmud",1947,17948));
		stateDetailMap.put("PR",new StateDTO("PR", "Puerto Rico","San Juan",1898,3411307));
		stateDetailMap.put("VI",new StateDTO("VI", "Virgin Islands","Charlotte Amaile",1917,106792));
		stateDetailMap.put("AE",new StateDTO("AE", "Armed Forces Africa,Canada,Europe",null,0,0));
		stateDetailMap.put("AA",new StateDTO("AA", "Armed Forces Americas",null,0,0));
		stateDetailMap.put("AP",new StateDTO("AP", "Armed Forces Pacific",null,0,0));
	}

	private StateDetailService() {
		
	}
	
	public static StateDetailService getInstance() {
		return instance;
	}
	
	public List<StateDTO> getStateList() {
		
		List<StateDTO> stateList = new ArrayList<StateDTO>();
		stateList.addAll(stateDetailMap.values());
		stateList.sort(new StateComparator());
		return stateList;
	}
}
