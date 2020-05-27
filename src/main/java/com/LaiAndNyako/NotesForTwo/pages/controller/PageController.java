package com.LaiAndNyako.NotesForTwo.pages.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	private static Set<String> guiguiIp = new HashSet<>();
	
	static {
		guiguiIp.add("192.168.3.10");
		guiguiIp.add("192.168.3.6");
		guiguiIp.add("192.168.3.3");
	}
	
	@GetMapping(value = "/")
	public ModelAndView MainPage(HttpServletRequest req) {
		System.out.println("aa" + req.getRemoteAddr());
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		model.addObject("guessName", guiguiIp.contains(req.getRemoteAddr())?"Nyako":"Lai");
		return model;
	}
}
