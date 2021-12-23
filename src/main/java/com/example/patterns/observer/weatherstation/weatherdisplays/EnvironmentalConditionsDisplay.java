package com.example.patterns.observer.weatherstation.weatherdisplays;

import com.example.patterns.observer.weatherstation.*;

public class EnvironmentalConditionsDisplay extends AbstractWeatherDisplay {
    private float temperature;
	private float humidity;
	
	public EnvironmentalConditionsDisplay(WeatherData weatherData) {
		super(weatherData);
	}
	
    @Override
	public void update() {
		temperature = weatherData.getTemperature();
		humidity = weatherData.getHumidity();
	}
	
    @Override
	public void display() {
		System.out.println("Current conditions: " + temperature 
			+ "F degrees and " + humidity + "% humidity.");
	}
}