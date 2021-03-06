package com.techelevator.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.ParkDAO;
import com.techelevator.npgeek.Weather;
import com.techelevator.npgeek.WeatherDAO;

@Controller 
public class ParkController {

	@Autowired
	ParkDAO parkDao;
	
	@Autowired
	WeatherDAO weatherDao;
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String goHome(ModelMap modelHolder){
		List<Park> allParks = new ArrayList<>();
		allParks = parkDao.getAllParks();
		
		modelHolder.addAttribute("allParks", allParks);
		
		return "home";
	}
	
	@RequestMapping(path="/parkDetail/{parkCode}", method=RequestMethod.GET)
	public String showParkDetail(@PathVariable String parkCode, ModelMap modelHolder, HttpSession session){
		Park tempPark = parkDao.getParkByParkCode(parkCode);		
		List<Weather> tempWeather = weatherDao.allWeatherFromParkCode(parkCode);
		if(session.getAttribute("preference") == null){
			String tempLabel = "default";
			session.setAttribute("preference", tempLabel);
		}
		if(session.getAttribute("preference").equals("celcius")){
			for(int i = 0; i < tempWeather.size(); i++){
				int newTemp = tempWeather.get(i).convertToCelcius(tempWeather.get(i).getHigh());
				tempWeather.get(i).setHigh(newTemp);
				int newTemp2 = tempWeather.get(i).convertToCelcius(tempWeather.get(i).getLow());
				tempWeather.get(i).setLow(newTemp2);
			}
		}
			else if(session.getAttribute("preference").equals("fahrenheit")){
			for(int i = 0; i < tempWeather.size(); i++){
				int newTemp = tempWeather.get(i).convertToFahrenheit(tempWeather.get(i).getHigh());
				tempWeather.get(i).setHigh(newTemp);
				int newTemp2 = tempWeather.get(i).convertToFahrenheit(tempWeather.get(i).getLow());
				tempWeather.get(i).setLow(newTemp2);
			}
			}
		
		modelHolder.addAttribute("park", tempPark);
		modelHolder.addAttribute("weather", tempWeather);
		
		return "parkDetail";
	}
	
	@RequestMapping(path="/parkDetail/{parkCode}", method=RequestMethod.POST)
	public String changeTempLabel(@PathVariable String parkCode, @RequestParam String tempLabel, HttpSession session){
	
		session.setAttribute("preference", tempLabel);
		
		return "redirect:/parkDetail/" + parkCode;
	}
	
}
