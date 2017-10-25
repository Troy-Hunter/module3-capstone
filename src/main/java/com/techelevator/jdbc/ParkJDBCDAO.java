package com.techelevator.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.ParkDAO;

@Component
public class ParkJDBCDAO implements ParkDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	
	@Autowired
	public ParkJDBCDAO(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	@Override
	public List<Park> getAllParks(){
		List<Park> parkList = new ArrayList<Park>();
		String sqlSelectAll = "SELECT * FROM park";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelectAll);
		
		while(result.next()){
			Park tempPark = new Park();
			tempPark.setAcreage(result.getInt("acreage"));
			tempPark.setAnnualVisitorCount(result.getInt("annualvisitorcount"));
			tempPark.setClimate(result.getString("climate"));
			tempPark.setElevationInFeet(result.getInt("elevationinfeet"));
			tempPark.setEntryFee(result.getInt("entryfee"));
			tempPark.setInspirationalQuote(result.getString("inspirationalquote"));
			tempPark.setInspirationalQuoteSource(result.getString("inspirationalquotesource"));
			tempPark.setMilesOfTrail(result.getBigDecimal("milesoftrail"));
			tempPark.setNumberOfAnimalSpecies(result.getInt("numberofanimalspecies"));
			tempPark.setNumberOfCampsites(result.getInt("numberofcampsites"));
			tempPark.setParkCode(result.getString("parkcode"));
			tempPark.setParkDescription(result.getString("parkdescription"));
			tempPark.setParkName(result.getString("parkname"));
			tempPark.setState(result.getString("state"));
			tempPark.setYearFounded(result.getInt("yearfounded"));
			parkList.add(tempPark);
		}
		
		
		return parkList;
	}

	@Override
	public Park getParkByParkCode(String parkCode) {
		Park tempPark = new Park();
		String sqlSelect = "SELECT * FROM park WHERE parkcode = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelect, parkCode);
		
		while(result.next()){
		tempPark.setAcreage(result.getInt("acreage"));
		tempPark.setAnnualVisitorCount(result.getInt("annualvisitorcount"));
		tempPark.setClimate(result.getString("climate"));
		tempPark.setElevationInFeet(result.getInt("elevationinfeet"));
		tempPark.setEntryFee(result.getInt("entryfee"));
		tempPark.setInspirationalQuote(result.getString("inspirationalquote"));
		tempPark.setInspirationalQuoteSource(result.getString("inspirationalquotesource"));
		tempPark.setMilesOfTrail(result.getBigDecimal("milesoftrail"));
		tempPark.setNumberOfAnimalSpecies(result.getInt("numberofanimalspecies"));
		tempPark.setNumberOfCampsites(result.getInt("numberofcampsites"));
		tempPark.setParkCode(result.getString("parkcode"));
		tempPark.setParkDescription(result.getString("parkdescription"));
		tempPark.setParkName(result.getString("parkname"));
		tempPark.setState(result.getString("state"));
		tempPark.setYearFounded(result.getInt("yearfounded"));
		}
		
		return tempPark;
	}
}
