package com.techelevator.npgeek;

import java.util.List;

public interface SurveyResultDAO {

	public List<SurveyResult> getAllSurveys();
	public void save(SurveyResult survey);

}
