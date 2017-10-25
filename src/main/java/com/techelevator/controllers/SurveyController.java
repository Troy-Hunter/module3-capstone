package com.techelevator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.npgeek.ParkDAO;

@Controller
public class SurveyController {

	
	@Autowired
	ParkDAO parkDao;
	
	@RequestMapping(path="/Survey", method=RequestMethod.GET)
	public String goToSurvey(){
		return "survey";
	}
	
}
