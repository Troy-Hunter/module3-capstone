package com.techelevator.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.ParkDAO;
import com.techelevator.npgeek.SurveyResult;
import com.techelevator.npgeek.SurveyResultDAO;

@Controller
public class SurveyController {

	
	@Autowired
	SurveyResultDAO surveyResultsDAO;
	@Autowired
	ParkDAO parkDAO;
	
	@RequestMapping(path="/Survey", method=RequestMethod.GET)
	public String goToSurvey(Model modelHolder){
		if(! modelHolder.containsAttribute("survey")){
			modelHolder.addAttribute("survey", new SurveyResult());
		}
		return "survey";
	}

	@RequestMapping(path="/surveyResults", method=RequestMethod.GET)
	public String goToSurveyResults(ModelMap modelHolder){
		List <Park> parks = new ArrayList<>();
		parks = parkDAO.topFiveSurveys();
		
		modelHolder.addAttribute("parks", parks);
		return "surveyResults";
	}
	
	@RequestMapping(path="/Survey", method=RequestMethod.POST)
	public String save(@Valid @ModelAttribute SurveyResult survey, BindingResult result, RedirectAttributes flash){
		flash.addFlashAttribute("survey", survey);
		if(result.hasErrors()){
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "survey", result);
			return "redirect:/Survey";
		}
		surveyResultsDAO.save(survey);
		return "redirect:/surveyResults";
	}
	
		
}
