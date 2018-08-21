package org.sebek.struts1.example.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/menupage")
public class MenuPage {
    
    @RequestMapping("/one")
    public ModelAndView one (HttpServletRequest request, HttpServletResponse response) {
        
        String message = "! Menu Item One !";
        return new ModelAndView(".view.menu.item.one", "message", message);
    }

    @RequestMapping("/two")
    public ModelAndView two (HttpServletRequest request, HttpServletResponse response) {
        
        String message = "! Menu Item Two !";
        return new ModelAndView(".view.menu.item.two", "message", message);
    }

    @RequestMapping("/three")
    public ModelAndView three (HttpServletRequest request, HttpServletResponse response) {
        
        String message = "! Menu Item Three !";
        return new ModelAndView(".view.menu.item.three", "message", message);
    }

    @RequestMapping("/four")
    public ModelAndView four (HttpServletRequest request, HttpServletResponse response) {
        
        String message = "! Menu Item Four !";
        return new ModelAndView(".view.menu.item.one", "message", message);
    }

}
