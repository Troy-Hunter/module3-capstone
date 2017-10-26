package com.techelevator.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.SurveyResult;
import com.techelevator.npgeek.SurveyResultDAO;

@Component
public class SurveyResultJDBCDAO implements SurveyResultDAO {
	
private JdbcTemplate jdbcTemplate;
	
	
	@Autowired
	public SurveyResultJDBCDAO(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<SurveyResult> getAllSurveys() {
		List<SurveyResult> survey = new ArrayList<>();
		String sqlSelectAll = "SELECT * FROM survey_result";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAll);
		while(results.next()){
			SurveyResult tempSurvey = new SurveyResult();
			tempSurvey.setActivityLevel(results.getString("activitylevel"));
			tempSurvey.setEmailAddress(results.getString("emailaddress"));
			tempSurvey.setParkCode(results.getString("parkcode"));
			tempSurvey.setState(results.getString("state"));
			tempSurvey.setSurveyId(results.getLong("surveyid"));
			survey.add(tempSurvey);
		}		
		return survey;
	}

	@Override
	public void save(SurveyResult survey) {
		String sqlInsertSurvey = "INSERT INTO survey_result(parkcode, emailaddress, state, activitylevel) VALUES (?,?,?,?)";
		jdbcTemplate.update(sqlInsertSurvey, survey.getParkCode(), survey.getEmailAddress(), survey.getState(), survey.getActivityLevel());
		
	}
	

}
