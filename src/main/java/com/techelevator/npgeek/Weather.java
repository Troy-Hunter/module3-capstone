package com.techelevator.npgeek;

public class Weather {

	private String parkCode;
	private int fiveDayForecastValue;
	private int low;
	private int high;
	private String forecast;
	
	public String printSaying(String forecast){
		if(forecast.equals("snow")){
			return "Pack Snowshoes.";
		}
		if(forecast.equals("rain")){
			return "Pack Rain Gear and Wear Waterproof Shoes.";
		}
		if(forecast.equals("thunderstorms")){
			return "Seek Shelter and Avoid Hiking.";
		}
		if(forecast.equals("sun")){
			return "Pack Sunblock.";
		}else{
			return "";
		}
	}
	
	public String printTempSaying(int high, int low){
		String result = null;
		if(high > 75 && ((high - low) > 20)){
			result = "Bring an Extra Gallon of Water. Also Wear Breathable Layers";
		}
		else if(((high - low) > 20) && (high < 75) && (low > 20)){
			result = "Wear Breathable Layers.";
		}
		else if(low < 20 && ((high - low) > 20)){
			result = "Danger of Exposure to Frigid Temperatures. Also Wear Breathable Layers";
		}
		else if(high > 75 && ((high - low) < 20)){
			result = "Bring an Extra Gallon of Water.";
		}
		else if(low < 20 && ((high - low) < 20)){
			result = "Danger of Exposure to Frigid Temperatures.";
		}
		else{
			
		}
		return result;
	}
	
	public int convertToCelcius(int temp){
		double result = (double) (temp - 32);
		result = result / 1.8;
		result = result * 10;
		if((result % 10) > 4){
			return (int) result + 1;
		}
		else if((result % 10) < 5){
			return (int) result;
		}
		else{
			return (int) result;
		}
		
	}
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public int getFiveDayForecastValue() {
		return fiveDayForecastValue;
	}
	public void setFiveDayForecastValue(int fiveDayForecastValue) {
		this.fiveDayForecastValue = fiveDayForecastValue;
	}
	public int getLow() {
		return low;
	}
	public void setLow(int low) {
		this.low = low;
	}
	public int getHigh() {
		return high;
	}
	public void setHigh(int high) {
		this.high = high;
	}
	public String getForecast() {
		return forecast;
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	
	
}
