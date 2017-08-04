package org.sebek.struts1.example.controller;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.beans.SimpleMenuItem;
import org.apache.tiles.preparer.PreparerException;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;

/*
 * https://www.google.com/search?client=safari&rls=en&q=integrating+struts+tiles+with+spring+mvc&ie=UTF-8&oe=UTF-8
 * http://www.codingpedia.org/ama/spring-mvc-and-apache-tiles-integration-example/
 * https://tiles.apache.org/framework/tutorial/advanced/preparer.html
 * https://stackoverflow.com/questions/20822692/spring-3-mvc-and-tiles-populate-jsp-page-with-some-data-before
 */

public class MenuControllerAction implements ViewPreparer {
	
//public class MenuControllerAction extends TilesAction {
	
	private static Map<String,String> linkMap; 
	
	static {
		linkMap = new LinkedHashMap<String,String>();
		linkMap.put("Welcome", "/do/welcome");
		linkMap.put("HelloWorld", "/do/helloWorld");
//		linkMap.put("Employee", "/do/employeeSummary?method=add");
		linkMap.put("Employee", "/do/employee/summary");

	}
	
	public void execute(Request tilesRequest, AttributeContext attributeContext) throws PreparerException {

		List<SimpleMenuItem> links = new ArrayList<SimpleMenuItem>(linkMap.size());
			
		for (String key : linkMap.keySet()) {
			SimpleMenuItem menuItem = new SimpleMenuItem();
			menuItem.setLink(linkMap.get(key));
			menuItem.setValue(key);
			links.add(menuItem);
		}
		attributeContext.putAttribute("menuItems", new Attribute(links));
	}
}
