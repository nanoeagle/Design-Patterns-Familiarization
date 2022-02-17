package com.example.patterns.observer.weatherstation.weatherdisplays;

import com.example.patterns.observer.weatherstation.data.WeatherData;

public class ForecastDisplay extends AbstractWeatherDisplay {
	private float currentPressure = 29.92f;  
	private float lastRecordedPressure;

	public ForecastDisplay(WeatherData weatherData) {
		super(weatherData);
	}

    @Override
	public void update() {
        lastRecordedPressure = currentPressure;
		currentPressure = weatherData.getPressure();
	}

    @Override
	public void display() {
		System.out.print("Forecast: ");
		if (currentPressure > lastRecordedPressure) 
			System.out.println("Improving weather on the way!");
		else if (currentPressure == lastRecordedPressure)
			System.out.println("More of the same.");
        else System.out.println("Watch out for cooler, rainy weather.");
	}
}