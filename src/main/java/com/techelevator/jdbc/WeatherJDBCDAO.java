package com.techelevator.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.Weather;
import com.techelevator.npgeek.WeatherDAO;

@Component
public class WeatherJDBCDAO implements WeatherDAO {

private JdbcTemplate jdbcTemplate;
	
	
	@Autowired
	public WeatherJDBCDAO(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Weather> allWeatherFromParkCode(String parkCode){
		List<Weather> newList = new ArrayList<>();
		String SqlRequest = "SELECT * FROM weather WHERE parkcode = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(SqlRequest, parkCode);
		
		while(result.next()){
			Weather tempWeather = new Weather();
			tempWeather.setFiveDayForecastValue(result.getInt("fivedayforecastvalue"));
			tempWeather.setForecast(result.getString("forecast"));
			tempWeather.setHigh(result.getInt("high"));
			tempWeather.setLow(result.getInt("low"));
			tempWeather.setParkCode(result.getString("parkcode"));
			newList.add(tempWeather);
		}
		
		return newList;
		
	}
	
	
}
